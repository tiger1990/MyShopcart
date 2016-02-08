package testemail.com.myshopcart.account;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.widget.TextView;

import testemail.com.myshopcart.R;
import testemail.com.myshopcart.account.adapter.LoginRegisterTabAdapter;

/**
 * Created by Deepak Pawar on 2/5/2016.
 */
public class LoginRegisterTabActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener
{

    private ViewPager _loginregisterViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_login);
        initViews();
    }

    private void initViews()
    {
        TabLayout loginRegisterTablayout = (TabLayout) findViewById(R.id.loginRegisterTablayout);
        _loginregisterViewPager = (ViewPager) findViewById(R.id.loginregisterViewPager);
        loginRegisterTablayout.addTab(loginRegisterTablayout.newTab().setCustomView(getCustomizeTabTextView(getResources().getString(R.string.loginTab))));
        loginRegisterTablayout.addTab(loginRegisterTablayout.newTab().setCustomView(getCustomizeTabTextView(getResources().getString(R.string.registerTab))));
        loginRegisterTablayout.setOnTabSelectedListener(this);
        loginRegisterTablayout.setTabGravity(TabLayout.GRAVITY_FILL);
        setupViewPager(loginRegisterTablayout);
    }

    private void setupViewPager(TabLayout loginRegisterTablayout)
    {

        LoginRegisterTabAdapter landingPagerAdapter = new LoginRegisterTabAdapter(getSupportFragmentManager(), loginRegisterTablayout.getTabCount());
        _loginregisterViewPager.setAdapter(landingPagerAdapter);
        /***It will take title from getPageTitle **/
        //_homeTablayout.setupWithViewPager(_homeViewPager);
        _loginregisterViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(loginRegisterTablayout));

    }

    public TextView getCustomizeTabTextView(String tabTitle)
    {
        TextView _tabName = (TextView) LayoutInflater.from(this).inflate(R.layout.login_register_tabview, null, false);
        _tabName.setText(tabTitle);

        return _tabName;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab)
    {
        _loginregisterViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab)
    {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab)
    {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == android.R.id.action_)
//        {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    public enum AccountTabs
    {
        LOGIN("Login", 0),
        REGISTER("Register", 1);

        String _tabName;
        int _tabPosition;

        AccountTabs(String tabName, int code)
        {
            this._tabName = tabName;
            this._tabPosition = code;
        }

        AccountTabs(int code)
        {
            this._tabPosition = code;
        }

        public String getTabName()
        {
            return _tabName;
        }

        public int getCode()
        {
            return _tabPosition;
        }
    }
}
