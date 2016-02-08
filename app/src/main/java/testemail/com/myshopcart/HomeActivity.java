package testemail.com.myshopcart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import testemail.com.myshopcart.account.AccountActivity;
import testemail.com.myshopcart.category.CategoryFragment;
import testemail.com.myshopcart.product.ProductFragment;

public class HomeActivity extends BaseActivity implements View.OnClickListener, IFragmentNavigationCallback
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initView();

    }

    private void initView()
    {
        ImageView homeTab = (ImageView) findViewById(R.id.homeTab);
        ImageView categoryTab = (ImageView) findViewById(R.id.categoryTab);
        ImageView offersTab = (ImageView) findViewById(R.id.offersTab);
        ImageView cartTab = (ImageView) findViewById(R.id.cartTab);
        ImageView accountTab = (ImageView) findViewById(R.id.accountTab);
        homeTab.setOnClickListener(this);
        categoryTab.setOnClickListener(this);
        offersTab.setOnClickListener(this);
        cartTab.setOnClickListener(this);
        accountTab.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.homeTab:

                toggleTabSelected("HomeTab");
                break;

            case R.id.categoryTab:
                toggleTabSelected("CategoryTab");
                swapFragmentInContainer(new CategoryFragment());
                break;

            case R.id.offersTab:
                toggleTabSelected("OffersTab");
                break;

            case R.id.cartTab:
                toggleTabSelected("CartTab");
                break;

            case R.id.accountTab:
                toggleTabSelected("AccountTab");
                break;
        }
    }

    private void swapFragmentInContainer(Fragment fragment)
    {
        navigateTo(getSupportFragmentManager(), fragment, R.id.frameContainer, false, false);
    }

    private void toggleTabSelected(String tabSelected)
    {
        ImageView homeTab = (ImageView) findViewById(R.id.homeTab);
        ImageView categoryTab = (ImageView) findViewById(R.id.categoryTab);
        ImageView offersTab = (ImageView) findViewById(R.id.offersTab);
        ImageView cartTab = (ImageView) findViewById(R.id.cartTab);
        ImageView accountTab = (ImageView) findViewById(R.id.accountTab);
        homeTab.setSelected(false);
        categoryTab.setSelected(false);
        offersTab.setSelected(false);
        cartTab.setSelected(false);
        accountTab.setSelected(false);

        if (tabSelected.equalsIgnoreCase("HomeTab"))
        {
            homeTab.setSelected(true);

        }
        else if (tabSelected.equalsIgnoreCase("CategoryTab"))
        {
            categoryTab.setSelected(true);

        }
        else if (tabSelected.equalsIgnoreCase("OffersTab"))
        {
            offersTab.setSelected(true);
        }
        else if (tabSelected.equalsIgnoreCase("CartTab"))
        {
            cartTab.setSelected(true);
        }
        //AccountTab
        else
        {
            accountTab.setSelected(true);
            moveToAccountTab();

        }
    }

    private void moveToAccountTab()
    {
        Intent accountIntent = new Intent(HomeActivity.this, AccountActivity.class);
        accountIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(accountIntent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.actionHeart)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void navigateToNestedFragment(FragmentManager fragmentManager, Fragment fragment)
    {
        navigateTo(fragmentManager, new ProductFragment(), R.id.frameContainer, false, true);
    }
}
