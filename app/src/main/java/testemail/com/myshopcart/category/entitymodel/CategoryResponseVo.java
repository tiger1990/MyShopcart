package testemail.com.myshopcart.category.entitymodel;

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
public class CategoryResponseVo extends WebResponseVo implements JsonDeserializer<CategoryResponseVo>
{
    private ArrayList<CategoryResponseVo> _categoryResponseList;
    protected boolean isValidJson;
    private String _categoryId, _categoryName, _categoryDesc;

    public CategoryResponseVo()
    {
        _categoryResponseList = new ArrayList<CategoryResponseVo>();
    }

    @Override
    public CategoryResponseVo deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
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
        CategoryResponseVo categoryResponseVo = new CategoryResponseVo();
        categoryResponseVo.setCategoryId(getStringValueFromKey(categoryResponse, "category_id"));
        categoryResponseVo.setCategoryName(getStringValueFromKey(categoryResponse, "name"));
        categoryResponseVo.setCategoryDesc(getStringValueFromKey(categoryResponse, "description"));

        _categoryResponseList.add(categoryResponseVo);
    }

    public boolean isValidJson()
    {
        return isValidJson;
    }

    public String getCategoryId()
    {
        return _categoryId;
    }

    public String getCategoryName()
    {
        return _categoryName;
    }

    public String getCategoryDesc()
    {
        return _categoryDesc;
    }

    public ArrayList<CategoryResponseVo> getCategoryResponseList()
    {
        return _categoryResponseList;
    }

    public void setCategoryId(String _categoryId)
    {
        this._categoryId = _categoryId;
    }

    public void setCategoryName(String _categoryName)
    {
        this._categoryName = _categoryName;
    }

    public void setCategoryDesc(String _categoryDesc)
    {
        this._categoryDesc = _categoryDesc;
    }
}