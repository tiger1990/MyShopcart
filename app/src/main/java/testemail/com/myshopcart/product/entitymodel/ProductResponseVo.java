package testemail.com.myshopcart.product.entitymodel;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

import testemail.com.myshopcart.network.WebResponseVo;

/**
 * Created by rohit on 2/7/2016.
 */
public class ProductResponseVo extends WebResponseVo implements JsonDeserializer<ProductResponseVo>
{
    private ArrayList<ProductResponseVo> _productResponseVos;
    protected boolean isValidJson;
    private String _productName;
    private String _megaTagDescription;
    private String _megaTagKeyword;
    private String _productDescription;
    private String _price;
    private String _composition;
    private String _tag;
    private String _imageUrl;
    private String _status;
    private String _seoKeyword;
    private String _minimumQuantity;
    private String _substractStock;
    private String _outOfStockStatus;
    private String _shippingRequired;
    private String _manufacturerName;

    private String _category;
    private String _filter;
    private String _relatedProduct;
    private String _attribute;
    private String _discount;
    private String _location;
    private String _rewardPoints;
    private String _posteduser;
    private String _createdtime;

    private String _productId;

    public ProductResponseVo()
    {
        _productResponseVos = new ArrayList<ProductResponseVo>();
    }

    @Override
    public ProductResponseVo deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        if (json.isJsonObject())
        {
            isValidJson = true;
            JsonObject categoryResponse = json.getAsJsonObject();
            JsonArray categoryJsonArray = categoryResponse.get("data").getAsJsonArray();
            for (int i = 0; i < categoryJsonArray.size(); i++)
            {
                parseCategoryResponse((JsonObject) categoryJsonArray.get(i));
            }
        }
        else
        {
            isValidJson = false;
        }
        return this;
    }

    private void parseCategoryResponse(JsonObject categoryResponse)
    {
        ProductResponseVo ProductResponseVo = new ProductResponseVo();
        ProductResponseVo.setproductName(getStringValueFromKey(categoryResponse, "product_name"));
        ProductResponseVo.setproductId(getStringValueFromKey(categoryResponse, "product_id"));
        ProductResponseVo.setmegaTagDescription(getStringValueFromKey(categoryResponse, "meta_tag_description"));
        ProductResponseVo.setmegaTagKeyword(getStringValueFromKey(categoryResponse, "meta_tag_keyword"));
        ProductResponseVo.setproductDescription(getStringValueFromKey(categoryResponse, "product_description"));
        ProductResponseVo.setprice(getStringValueFromKey(categoryResponse, "price"));
        ProductResponseVo.setcomposition(getStringValueFromKey(categoryResponse, "composition"));
        ProductResponseVo.settag(getStringValueFromKey(categoryResponse, "tag"));
        ProductResponseVo.setimageUrl(getStringValueFromKey(categoryResponse, "image"));
        ProductResponseVo.setstatus(getStringValueFromKey(categoryResponse, "status"));
        ProductResponseVo.setseoKeyword(getStringValueFromKey(categoryResponse, "seo_keyword"));
        ProductResponseVo.setminimumQuantity(getStringValueFromKey(categoryResponse, "minimum_quantity"));
        ProductResponseVo.setsubstractStock(getStringValueFromKey(categoryResponse, "substract_stock"));
        ProductResponseVo.setoutOfStockStatus(getStringValueFromKey(categoryResponse, "out_of_stock_status"));
        ProductResponseVo.setshippingRequired(getStringValueFromKey(categoryResponse, "requires_shipping"));

        ProductResponseVo.setmanufacturerName(getStringValueFromKey(categoryResponse, "manufacturer"));
        ProductResponseVo.setcategory(getStringValueFromKey(categoryResponse, "category"));
        ProductResponseVo.setfilter(getStringValueFromKey(categoryResponse, "filter"));
        ProductResponseVo.setrelatedProduct(getStringValueFromKey(categoryResponse, "related_products"));
        ProductResponseVo.setattribute(getStringValueFromKey(categoryResponse, "attribute"));
        ProductResponseVo.setdiscount(getStringValueFromKey(categoryResponse, "discount"));
        ProductResponseVo.setlocation(getStringValueFromKey(categoryResponse, "location"));
        ProductResponseVo.setrewardPoints(getStringValueFromKey(categoryResponse, "rewards_points"));
        ProductResponseVo.setposteduser(getStringValueFromKey(categoryResponse, "posteduser"));
        ProductResponseVo.setcreatedtime(getStringValueFromKey(categoryResponse, "createdtime"));
        _productResponseVos.add(ProductResponseVo);
    }

    public boolean isValidJson()
    {
        return isValidJson;
    }

    public String getmegaTagDescription()
    {
        return _megaTagDescription;
    }

    public void setmegaTagDescription(String _megaTagDescription)
    {
        this._megaTagDescription = _megaTagDescription;
    }

    public ArrayList<ProductResponseVo> getproductResponseVos()
    {
        return _productResponseVos;
    }

    public void setproductResponseVos(ArrayList<ProductResponseVo> _productResponseVos)
    {
        this._productResponseVos = _productResponseVos;
    }

    public void setIsValidJson(boolean isValidJson)
    {
        this.isValidJson = isValidJson;
    }

    public String getproductName()
    {
        return _productName;
    }

    public void setproductName(String _productName)
    {
        this._productName = _productName;
    }

    public String getmegaTagKeyword()
    {
        return _megaTagKeyword;
    }

    public void setmegaTagKeyword(String _megaTagKeyword)
    {
        this._megaTagKeyword = _megaTagKeyword;
    }

    public String getproductDescription()
    {
        return _productDescription;
    }

    public void setproductDescription(String _productDescription)
    {
        this._productDescription = _productDescription;
    }

    public String getprice()
    {
        return _price;
    }

    public void setprice(String _price)
    {
        this._price = _price;
    }

    public String getcomposition()
    {
        return _composition;
    }

    public void setcomposition(String _composition)
    {
        this._composition = _composition;
    }

    public String gettag()
    {
        return _tag;
    }

    public void settag(String _tag)
    {
        this._tag = _tag;
    }

    public String getimageUrl()
    {
        return _imageUrl;
    }

    public void setimageUrl(String _imageUrl)
    {
        this._imageUrl = _imageUrl;
    }

    public String getstatus()
    {
        return _status;
    }

    public void setstatus(String _status)
    {
        this._status = _status;
    }

    public String getseoKeyword()
    {
        return _seoKeyword;
    }

    public void setseoKeyword(String _seoKeyword)
    {
        this._seoKeyword = _seoKeyword;
    }

    public String getminimumQuantity()
    {
        return _minimumQuantity;
    }

    public void setminimumQuantity(String _minimumQuantity)
    {
        this._minimumQuantity = _minimumQuantity;
    }

    public String getsubstractStock()
    {
        return _substractStock;
    }

    public void setsubstractStock(String _substractStock)
    {
        this._substractStock = _substractStock;
    }

    public String getoutOfStockStatus()
    {
        return _outOfStockStatus;
    }

    public void setoutOfStockStatus(String _outOfStockStatus)
    {
        this._outOfStockStatus = _outOfStockStatus;
    }

    public String getshippingRequired()
    {
        return _shippingRequired;
    }

    public void setshippingRequired(String _shippingRequired)
    {
        this._shippingRequired = _shippingRequired;
    }


    public String getproductId()
    {
        return _productId;
    }

    public void setproductId(String _productId)
    {
        this._productId = _productId;
    }

    public String getcategory()
    {
        return _category;
    }

    public void setcategory(String _category)
    {
        this._category = _category;
    }

    public String getmanufacturerName()
    {
        return _manufacturerName;
    }

    public void setmanufacturerName(String _manufacturerName)
    {
        this._manufacturerName = _manufacturerName;
    }

    public String getfilter()
    {
        return _filter;
    }

    public void setfilter(String _filter)
    {
        this._filter = _filter;
    }

    public String getrelatedProduct()
    {
        return _relatedProduct;
    }

    public void setrelatedProduct(String _relatedProduct)
    {
        this._relatedProduct = _relatedProduct;
    }

    public String getattribute()
    {
        return _attribute;
    }

    public void setattribute(String _attribute)
    {
        this._attribute = _attribute;
    }

    public String getdiscount()
    {
        return _discount;
    }

    public void setdiscount(String _discount)
    {
        this._discount = _discount;
    }

    public String getlocation()
    {
        return _location;
    }

    public void setlocation(String _location)
    {
        this._location = _location;
    }

    public String getrewardPoints()
    {
        return _rewardPoints;
    }

    public void setrewardPoints(String _rewardPoints)
    {
        this._rewardPoints = _rewardPoints;
    }

    public String getposteduser()
    {
        return _posteduser;
    }

    public void setposteduser(String _posteduser)
    {
        this._posteduser = _posteduser;
    }

    public String getcreatedtime()
    {
        return _createdtime;
    }

    public void setcreatedtime(String _createdtime)
    {
        this._createdtime = _createdtime;
    }

}