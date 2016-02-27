package org.pacemaker.main;

import java.util.List;
import org.pacemaker.http.Request;
import org.pacemaker.http.Response;
import org.pacemaker.http.Rest;
import org.pacemaker.models.JsonParser;
import org.pacemaker.models.User;
import android.content.Context;

public class PacemakerAPI
{
  public static void getUsers(Context context, Response<User> response, String dialogMesssage)
  {
    new GetUsers(context, response, dialogMesssage).execute();
  }

  public static void createUser(Context context, Response<User> response, String dialogMesssage, User user)
  {
    new CreateUser(context, response, dialogMesssage).execute(user);
  }
}

class GetUsers extends Request
{
  public GetUsers(Context context, Response<User> callback, String message)
  {
    super(context, callback, message);
  }

  @Override
  protected List<User> doRequest(Object... params) throws Exception
  {
    String response = Rest.get("/api/users");
    List<User> userList = JsonParser.json2Users(response);
    return userList;
  }
}

class CreateUser extends Request
{
  public CreateUser(Context context, Response<User> callback, String message)
  {
    super(context, callback, message);
  }

  @Override
  protected User doRequest(Object... params) throws Exception
  {
    String response = Rest.post("/api/users", JsonParser.user2Json(params[0]));
    return JsonParser.json2User(response);
  }
}