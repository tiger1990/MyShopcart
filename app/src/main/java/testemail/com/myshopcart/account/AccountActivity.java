package testemail.com.myshopcart.account;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import testemail.com.myshopcart.R;

/**
 * Created by Deepak Pawar on 2/5/2016.
 */
public class AccountActivity extends AppCompatActivity implements View.OnClickListener
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        initViews();
    }

    private void initViews()
    {
        TextView sellerLogin = (TextView) findViewById(R.id.sellerLogin);
        LinearLayout loginLayout = (LinearLayout) findViewById(R.id.loginLayout);
        sellerLogin.setOnClickListener(this);
        loginLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.sellerLogin:

                Intent sellerActivityIntent = new Intent(getApplicationContext(), SellerActivity.class);
                sellerActivityIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(sellerActivityIntent);

                break;

            case R.id.loginLayout:

                Intent loginIntent = new Intent(AccountActivity.this, LoginRegisterTabActivity.class);
                loginIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(loginIntent);

                break;
        }
    }
}
