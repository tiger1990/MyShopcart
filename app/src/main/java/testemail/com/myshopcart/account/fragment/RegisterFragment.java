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
import testemail.com.myshopcart.account.fragment.entitymodel.RegisterResponseVo;
import testemail.com.myshopcart.network.GsonGetRequest;
import testemail.com.myshopcart.network.NetworkApiRequest;
import testemail.com.myshopcart.network.WebResponseVo;
import testemail.com.myshopcart.utility.ToastUtility;

/**
 * Created by Deepak Pawar on 2/5/2016.
 */
public class RegisterFragment extends BaseFragment implements View.OnClickListener
{
    private EditText user, regemail, regpassword, phone, nickname;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        user = (EditText) view.findViewById(R.id.user);
        regemail = (EditText) view.findViewById(R.id.regemail);
        regpassword = (EditText) view.findViewById(R.id.regpassword);
        phone = (EditText) view.findViewById(R.id.phone);
        nickname = (EditText) view.findViewById(R.id.nickname);
        TextView register = (TextView) view.findViewById(R.id.register);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.register:

                if (!isNetworkConnected())
                {
                    ToastUtility.showToast(getContext(), R.string.networkError, ToastUtility.TOAST_DURATION);
                    return;
                }
                makeRegisterRequest(user.getText().toString(), regemail.getText().toString(), regpassword.getText().toString(), phone.getText().toString(), nickname.getText().toString());
                break;
        }

    }

    private String getRegisterUrl(String name, String email, String password, String nick_name, String mobile)
    {
        HashMap<String, String> signUpMap = new HashMap();
        signUpMap.put("name", name);
        signUpMap.put("email", email);
        signUpMap.put("password", password);
        signUpMap.put("nick_name", nick_name);
        signUpMap.put("mobile", mobile);

        StringBuilder urlParams = new StringBuilder();
        for (Map.Entry<String, String> entry : signUpMap.entrySet())
        {
            urlParams.append(entry.getKey() + "=" + entry.getValue() + "&");
        }
        return String.format("%s%s", ApplicationUrl.getRegisterUrl(), urlParams.toString());
    }

    private void makeRegisterRequest(String struser, String strregemail, String strregpassword, String strnickname, String strphone)
    {
        // showStatus(NetworkStatus.STATUS_LOADING, 0);
        showProgressDialog();
        GsonGetRequest<RegisterResponseVo> gsonSignUpPostRequest = NetworkApiRequest.getSignUpResponse
                (getRegisterUrl(struser, strregemail, strregpassword, strnickname, strphone),
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

        ApplicationController.getInstance().addToRequestQueue(gsonSignUpPostRequest);


    }

    private void onNetworkObjectResponse(WebResponseVo responseVo)
    {
        if (responseVo instanceof RegisterResponseVo)
        {
            validateSignUpResponse((RegisterResponseVo) responseVo);

        }
    }

    private void validateSignUpResponse(RegisterResponseVo registerResponse)
    {
        if (registerResponse.isValidJson())
        {
            ToastUtility.showToast(getContext(), registerResponse.getMessageResult(), Toast.LENGTH_SHORT);
        }
        else
        {
            ToastUtility.showToast(getContext(), "Incorrect Response", Toast.LENGTH_SHORT);
        }
    }
}
