package testemail.com.myshopcart.category;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.ArrayList;

import testemail.com.myshopcart.ApplicationController;
import testemail.com.myshopcart.ApplicationUrl;
import testemail.com.myshopcart.IFragmentNavigationCallback;
import testemail.com.myshopcart.R;
import testemail.com.myshopcart.account.fragment.BaseFragment;
import testemail.com.myshopcart.category.adapter.CategoryListAdapter;
import testemail.com.myshopcart.category.entitymodel.CategoryResponseVo;
import testemail.com.myshopcart.network.GsonGetRequest;
import testemail.com.myshopcart.network.NetworkApiRequest;
import testemail.com.myshopcart.network.WebResponseVo;
import testemail.com.myshopcart.product.ProductFragment;
import testemail.com.myshopcart.utility.ToastUtility;

/**
 * Created by rohit on 2/6/2016.
 */
public class CategoryFragment extends BaseFragment implements CategoryListAdapter.ICategoryClickListener
{
    private RecyclerView _recyclerViewCategory;
    private IFragmentNavigationCallback _fragmentNavigationCallback;

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        try
        {
            _fragmentNavigationCallback = (IFragmentNavigationCallback) context;
        }
        catch (ClassCastException e)
        {
            throw new ClassCastException(context.getClass().getSimpleName() + " must implement NavigationDrawerCallbacks");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        _recyclerViewCategory = (RecyclerView) view.findViewById(R.id.recyclerViewCategory);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this.getContext());
        _recyclerViewCategory.setLayoutManager(mLayoutManager);

        makeCategoryRequestCall();
    }

    private void makeCategoryRequestCall()
    {
        GsonGetRequest<CategoryResponseVo> gsonCategoryGetRequest = NetworkApiRequest.getCategoryResponse(ApplicationUrl.getCategoryUrl(),
                new Response.Listener<WebResponseVo>()
                {
                    @Override
                    public void onResponse(WebResponseVo responseVo)
                    {
                        // showStatus(NetworkStatus.STATUS_SUCCESS, 0);
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
                        //showStatus(NetworkStatus.STATUS_SUCCESS, 0);
                        handleResponseError(error);
                    }
                }
        );

        ApplicationController.getInstance().addToRequestQueue(gsonCategoryGetRequest);

    }

    private void onNetworkObjectResponse(WebResponseVo responseVo)
    {
        if (responseVo instanceof CategoryResponseVo)
        {
            validateCategoryResponse(responseVo);

        }
    }

    private void validateCategoryResponse(WebResponseVo responseVo)
    {
        if (responseVo instanceof CategoryResponseVo)
        {
            CategoryResponseVo categoryResponseVo = (CategoryResponseVo) responseVo;
            ArrayList<CategoryResponseVo> categoryResponseArrayList = categoryResponseVo.getCategoryResponseList();
            CategoryListAdapter categoryListAdapter = new CategoryListAdapter(categoryResponseArrayList, this);
            _recyclerViewCategory.setAdapter(categoryListAdapter);
        }
        else
        {
            ToastUtility.showToast(getContext(), "Incorrect Response", Toast.LENGTH_SHORT);
        }
    }

    @Override
    public void onCategoryClick(CategoryResponseVo categoryResponseVo)
    {
        _fragmentNavigationCallback.navigateToNestedFragment(getChildFragmentManager(),new ProductFragment());
    }
}
