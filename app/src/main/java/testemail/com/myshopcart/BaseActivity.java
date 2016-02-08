package testemail.com.myshopcart;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Deepak Pawar on 2/7/2016.
 */
public class BaseActivity extends AppCompatActivity
{
    private static final String TAG = BaseActivity.class.getSimpleName();

    /****
     * replace using getSupportFragmentManager (1st level fragment)
     ***/
    protected void navigateTo(FragmentManager fragmentManager, Fragment fragment, int frameContainer, boolean addReplace, boolean isBackStackAdd)
    {
        replaceContentFragment(getSupportFragmentManager(), fragment, addReplace, frameContainer, 0, 0, 0, 0, isBackStackAdd);
        fragmentManager.executePendingTransactions();
    }

    public void replaceContentFragment(FragmentManager fragmentManager, Fragment fragment, boolean toAdd, int containerId, int enterAnim, int exitAnim, int popEnterAnim, int popExitAnim, boolean addToBackStack)
    {
        // Return if fragment to be added in UiBaseActivity is null
        if (fragment == null)
        {
            throw new IllegalArgumentException("Null fragment passed in " + TAG + "#replaceContentFragment");
        }
        // getting the name of the fragment class
        String mFragmentName = ((Object) fragment).getClass().getSimpleName();
        // replace with new content
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // Animation for above ICS
        fragmentTransaction.setCustomAnimations(enterAnim, exitAnim, popEnterAnim, popExitAnim);
        if (toAdd)
        {
            fragmentTransaction.add(containerId, fragment, mFragmentName);
        }
        else
        {
            fragmentTransaction.replace(containerId, fragment, mFragmentName);
        }
        if (addToBackStack)
        {
            fragmentTransaction.addToBackStack(mFragmentName);
        }
        fragmentTransaction.commit();
    }
}
