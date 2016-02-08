package testemail.com.myshopcart;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * Created by Deepak Pawar on 2/7/2016.
 */
public interface IFragmentNavigationCallback
{
    public void navigateToNestedFragment(FragmentManager fragmentManager,Fragment fragment);
}
