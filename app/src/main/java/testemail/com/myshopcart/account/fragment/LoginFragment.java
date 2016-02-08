package testemail.com.myshopcart.account.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.HashMap;
import java.util.Map;

import testemail.com.myshopcart.ApplicationController;
import testemail.com.myshopcart.ApplicationUrl;
import testemail.com.myshopcart.R;
import testemail.com.myshopcart.account.fragment.entitymodel.LoginResponseVo;
import testemail.com.myshopcart.network.GsonGetRequest;
import testemail.com.myshopcart.network.NetworkApiRequest;
import testemail.com.myshopcart.network.WebResponseVo;
import testemail.com.myshopcart.utility.ToastUtility;

/**
 * Created by Deepak Pawar on 2/5/2016.
 */
public class LoginFragment extends BaseFragment implements View.OnClickListener
{
    private EditText user, password;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_userlogin, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        user = (EditText) view.findViewById(R.id.email);
        password = (EditText) view.findViewById(R.id.password);
        TextView register = (TextView) view.findViewById(R.id.login);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.login:

                if (!isNetworkConnected())
                {
                    ToastUtility.showToast(getContext(), R.string.networkError, ToastUtility.TOAST_DURATION);
                    return;
                }
                makeLoginRequest(user.getText().toString(), password.getText().toString());
                break;
        }

    }

    private String getLoginUrl(String email, String password)
    {
        HashMap<String, String> signUpMap = new HashMap();
        signUpMap.put("email", email);
        signUpMap.put("password", password);

        StringBuilder urlParams = new StringBuilder();
        for (Map.Entry<String, String> entry : signUpMap.entrySet())
        {
            urlParams.append(entry.getKey() + "=" + entry.getValue() + "&");
        }
        return String.format("%s%s", ApplicationUrl.getLoginUrl(), urlParams.toString());
    }

    private void makeLoginRequest(String struser, String strpassword)
    {
        // showStatus(NetworkStatus.STATUS_LOADING, 0);
        showProgressDialog();
        GsonGetRequest<LoginResponseVo> gsonLoginPostRequest = NetworkApiRequest.getLoginResponse
                (getLoginUrl(struser, strpassword),
                        new Response.Listener<WebResponseVo>()
                        {
                            @Override
                            public void onResponse(WebResponseVo responseVo)
                            {
                                // showStatus(NetworkStatus.STATUS_SUCCESS, 0);
                                hideProgressDialog();
                                onNetworkObjectResponse(responseVo);
                                hideProgressDialog();
                            }
                        }
                        ,
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error)
                            {
                                // ToastUtility.showToast(SignUpActivity.this, error.getCause().getMessage(), Toast.LENGTH_SHORT).show();
                                hideProgressDialog();
                                handleResponseError(error);
                            }
                        }
                );

        ApplicationController.getInstance().addToRequestQueue(gsonLoginPostRequest);


    }

    private void onNetworkObjectResponse(WebResponseVo responseVo)
    {
        if (responseVo instanceof LoginResponseVo)
        {
            validateLoginResponse((LoginResponseVo) responseVo);

        }
    }

    private void validateLoginResponse(LoginResponseVo loginResponseVo)
    {
        if (loginResponseVo.isValidJson())
        {
            ToastUtility.showToast(getContext(), loginResponseVo.getMessageResult(), Toast.LENGTH_SHORT);
        }
        else
        {
            ToastUtility.showToast(getContext(), "Incorrect Response", Toast.LENGTH_SHORT);
        }
    }
}
