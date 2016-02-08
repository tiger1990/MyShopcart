package testemail.com.myshopcart.account.adapter;

/**
 * Created by Deepak Pawar on 2/6/2016.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import testemail.com.myshopcart.account.LoginRegisterTabActivity;
import testemail.com.myshopcart.account.fragment.LoginFragment;
import testemail.com.myshopcart.account.fragment.RegisterFragment;

public class LoginRegisterTabAdapter extends FragmentPagerAdapter
{
    int mNumOfTabs;

    public LoginRegisterTabAdapter(FragmentManager fm, int NumOfTabs)
    {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position)
    {

        Fragment _contentTabFragment = null;
        LoginRegisterTabActivity.AccountTabs currentTab = LoginRegisterTabActivity.AccountTabs.values()[position];
        switch (currentTab)
        {
            case LOGIN:

                _contentTabFragment = new LoginFragment();
                break;

            case REGISTER:
                _contentTabFragment = new RegisterFragment();
                break;

        }
        return _contentTabFragment;
    }


    @Override
    public int getCount()
    {
        return mNumOfTabs;
    }
}
