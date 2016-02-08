package testemail.com.myshopcart.account.fragment.entitymodel;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import testemail.com.myshopcart.network.WebResponseVo;

/**
 * Created by Deepak Pawar on 2/7/2016.
 */
public class LoginResponseVo extends WebResponseVo implements JsonDeserializer<LoginResponseVo>
{
    protected boolean isValidJson;
    private String _messageResult;

    public boolean isValidJson()
    {
        return isValidJson;
    }

    @Override
    public LoginResponseVo deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        if (json.isJsonObject())
        {
            isValidJson = true;
            JsonObject loginResponseObject = json.getAsJsonObject();
            parseCommonResponse(loginResponseObject);
        }
        else
        {
            isValidJson = false;
        }
        return this;
    }

    private void parseCommonResponse(JsonObject loginResponseObject)
    {
        _messageResult = getStringValueFromKey(loginResponseObject, "message");
    }

    public String getMessageResult()
    {
        return _messageResult;
    }

}
