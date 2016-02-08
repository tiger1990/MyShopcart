package testemail.com.myshopcart.product;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
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
import testemail.com.myshopcart.R;
import testemail.com.myshopcart.account.fragment.BaseFragment;
import testemail.com.myshopcart.network.GsonGetRequest;
import testemail.com.myshopcart.network.NetworkApiRequest;
import testemail.com.myshopcart.network.WebResponseVo;
import testemail.com.myshopcart.product.adapter.ProductListAdapter;
import testemail.com.myshopcart.product.entitymodel.ProductResponseVo;
import testemail.com.myshopcart.utility.ToastUtility;

/**
 * Created by rohit on 2/6/2016.
 */
public class ProductFragment extends BaseFragment
{
    RecyclerView _recyclerViewProduct;

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
        _recyclerViewProduct = (RecyclerView) view.findViewById(R.id.recyclerViewCategory);
        GridLayoutManager mLayoutManager = new GridLayoutManager(this.getContext(), 2);
        _recyclerViewProduct.setLayoutManager(mLayoutManager);

        makeProductRequestCall();
    }

    private void makeProductRequestCall()
    {
        GsonGetRequest<ProductResponseVo> gsonProductGetRequest = NetworkApiRequest.getProductResponse(ApplicationUrl.getProductUrl(),
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

        ApplicationController.getInstance().addToRequestQueue(gsonProductGetRequest);

    }

    private void onNetworkObjectResponse(WebResponseVo responseVo)
    {
        if (responseVo instanceof ProductResponseVo)
        {
            validateProductResponse(responseVo);

        }
    }

    private void validateProductResponse(WebResponseVo responseVo)
    {
        if (responseVo instanceof ProductResponseVo)
        {
            ProductResponseVo ProductResponseVo = (ProductResponseVo) responseVo;
            ArrayList<ProductResponseVo> productResponseVos = ProductResponseVo.getproductResponseVos();
            ProductListAdapter productListAdapter = new ProductListAdapter(productResponseVos);
            _recyclerViewProduct.setAdapter(productListAdapter);
        }
        else
        {
            ToastUtility.showToast(getContext(), "Incorrect Response", Toast.LENGTH_SHORT);
        }
    }
}
