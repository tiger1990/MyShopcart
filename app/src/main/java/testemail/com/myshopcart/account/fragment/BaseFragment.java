package testemail.com.myshopcart.account.fragment;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;

import testemail.com.myshopcart.R;
import testemail.com.myshopcart.utility.NetworkChangeReceiver;

/**
 * Created by Deepak Pawar on 2/6/2016.
 */
public class BaseFragment extends Fragment implements Animation.AnimationListener
{
    private Animation _animFadein;
    private Dialog _progressDialog;

    protected boolean isNetworkConnected()
    {
        NetworkChangeReceiver.initNetwork(getContext());
        return NetworkChangeReceiver.isOnline();
    }

    public void showProgressDialog()
    {
        _progressDialog = new Dialog(getContext());
        _progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        _progressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        _progressDialog.setContentView(R.layout.network_progress_dialog);
        ImageView imageloader = (ImageView) _progressDialog.findViewById(R.id.pdimageloader);

        _animFadein = AnimationUtils.loadAnimation(getContext(), R.anim.blink);
        _animFadein.setAnimationListener(this);

        imageloader.startAnimation(_animFadein);
        _progressDialog.show();
        _progressDialog.setCancelable(false);

    }

    public void hideProgressDialog()
    {

        if (_progressDialog != null)
        {
            _progressDialog.dismiss();
        }

    }

    protected void handleResponseError(VolleyError networkError)
    {
        // Handle your error types accordingly.For Timeout & No connection error, you can show 'retry' button.
        // For AuthFailure, you can re login with user credentials.
        // For ClientError, 400 & 401, Errors happening on client side when sending api request.
        // In this case you can check how client is forming the api and debug accordingly.
        // For ServerError 5xx, you can do retry or handle accordingly.
        if (networkError instanceof NetworkError)
        {

        }
        else if (networkError instanceof ServerError)
        {
        }
        else if (networkError instanceof AuthFailureError)
        {
        }
        else if (networkError instanceof ParseError)
        {
        }
        else if (networkError instanceof NoConnectionError)
        {
        }
        else if (networkError instanceof TimeoutError)
        {
        }
    }

    @Override
    public void onAnimationStart(Animation animation)
    {
        if (animation == _animFadein)
        {

        }

    }

    @Override
    public void onAnimationEnd(Animation animation)
    {

    }

    @Override
    public void onAnimationRepeat(Animation animation)
    {

    }
}
