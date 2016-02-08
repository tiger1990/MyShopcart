package testemail.com.myshopcart.network;

import com.android.volley.Response;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import testemail.com.myshopcart.account.fragment.entitymodel.LoginResponseVo;
import testemail.com.myshopcart.account.fragment.entitymodel.RegisterResponseVo;
import testemail.com.myshopcart.category.entitymodel.CategoryResponseVo;
import testemail.com.myshopcart.product.entitymodel.ProductResponseVo;

/**
 * Created by Deepak Pawar on 1/26/2016.
 */
public class NetworkApiRequest
{
    /***************
     * SignUp request
     ************/
    private static Gson signUpGson = new GsonBuilder()
            .registerTypeAdapter(RegisterResponseVo.class, new RegisterResponseVo())
            .create();

    public static GsonGetRequest getSignUpResponse(String url, Response.Listener<WebResponseVo> listener, Response.ErrorListener errorListener)
    {
        GsonGetRequest gsonPostRequest = new GsonGetRequest<>
                (
                        url,
                        new TypeToken<RegisterResponseVo>()
                        {
                        }.getType(),
                        signUpGson,
                        listener,
                        errorListener
                );

        gsonPostRequest.setShouldCache(false);
        return gsonPostRequest;
    }

    /***************
     * Login request
     ************/

    private static Gson loginGson = new GsonBuilder()
            .registerTypeAdapter(LoginResponseVo.class, new LoginResponseVo())
            .create();

    public static GsonGetRequest getLoginResponse(String url, Response.Listener<WebResponseVo> listener, Response.ErrorListener errorListener)
    {
        GsonGetRequest gsonPostRequest = new GsonGetRequest<>
                (
                        url,
                        new TypeToken<LoginResponseVo>()
                        {
                        }.getType(),
                        loginGson,
                        listener,
                        errorListener
                );

        gsonPostRequest.setShouldCache(false);
        return gsonPostRequest;
    }

    /***************
     * CategoryResponse request
     ************/
    private static Gson categoryGson = new GsonBuilder()
            .registerTypeAdapter(CategoryResponseVo.class, new CategoryResponseVo())
            .create();

    public static GsonGetRequest getCategoryResponse(String url, Response.Listener<WebResponseVo> listener, Response.ErrorListener errorListener)
    {
        GsonGetRequest gsonGetRequest = new GsonGetRequest<>
                (
                        url,
                        new TypeToken<CategoryResponseVo>()
                        {
                        }.getType(),
                        categoryGson,
                        listener,
                        errorListener
                );

        gsonGetRequest.setShouldCache(false);
        return gsonGetRequest;
    }

    /***************
     * Product Response request
     ************/
    private static Gson productGson = new GsonBuilder()
            .registerTypeAdapter(ProductResponseVo.class, new ProductResponseVo())
            .create();

    public static GsonGetRequest getProductResponse(String url, Response.Listener<WebResponseVo> listener, Response.ErrorListener errorListener)
    {
        GsonGetRequest gsonGetRequest = new GsonGetRequest<>
                (
                        url,
                        new TypeToken<ProductResponseVo>()
                        {
                        }.getType(),
                        productGson,
                        listener,
                        errorListener
                );

        gsonGetRequest.setShouldCache(false);
        return gsonGetRequest;
    }

}
