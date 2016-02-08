package testemail.com.myshopcart;

/**
 * Created by Deepak Pawar on 2/6/2016.
 */
public class ApplicationUrl
{
    //Get
    private static final String REGISTER_URL = "http://directorypartner.in/shoppy/registration.php?";
    private static final String LOGIN_URL = "http://directorypartner.in/shoppy/login.php?";
    private static final String CATEGORY_URL = "http://directorypartner.in/shoppy/category.php?";
    private static final String PRODUCT_URL = "http://directorypartner.in/shoppy/product.php?category_id=1";

    public static String getRegisterUrl()
    {
        return REGISTER_URL;
    }

    public static String getCategoryUrl()
    {
        return CATEGORY_URL;
    }

    public static String getProductUrl()
    {
        return PRODUCT_URL;
    }

    public static String getLoginUrl()
    {
        return LOGIN_URL;
    }
}
