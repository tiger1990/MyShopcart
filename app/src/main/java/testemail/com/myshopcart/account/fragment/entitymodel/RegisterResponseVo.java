package testemail.com.myshopcart.account.fragment.entitymodel;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import testemail.com.myshopcart.network.WebResponseVo;

/**
 * Created by Deepak Pawar on 2/6/2016.
 */
public class RegisterResponseVo extends WebResponseVo implements JsonDeserializer<RegisterResponseVo>
{
    protected boolean isValidJson;
    private String _messageResult;

    public boolean isValidJson()
    {
        return isValidJson;
    }

    @Override
    public RegisterResponseVo deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        if (json.isJsonObject())
        {
            isValidJson = true;
            JsonObject registerResponseObject = json.getAsJsonObject();
            parseCommonResponse(registerResponseObject);
        }
        else
        {
            isValidJson = false;
        }
        return this;
    }

    private void parseCommonResponse(JsonObject registerResponseObject)
    {
        _messageResult = getStringValueFromKey(registerResponseObject, "message");
    }

    public String getMessageResult()
    {
        return _messageResult;
    }

}

