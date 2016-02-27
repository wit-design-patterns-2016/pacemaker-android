package org.pacemaker.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Application;
import android.util.Log;
import org.pacemaker.models.MyActivity;
import org.pacemaker.models.User;

public class PacemakerApp extends Application
{
  private List<MyActivity> activities = new ArrayList<MyActivity>();
  public  Map<String, User> users     = new HashMap<String, User>();
  private User              loggedInUser;

  public void registerUser(User user)
  {
    users.put(user.email, user);
  }

  public boolean loginUser(String email, String password)
  {
    loggedInUser = users.get(email);
    if (loggedInUser != null && !loggedInUser.password.equals(password))
    {
      loggedInUser = null;
    }
    return loggedInUser != null;
  }

  public void createActivity (MyActivity activity)
  {
    activities.add(activity);
  }

  public List<MyActivity> getActivities()
  {
    return activities;
  }

  @Override
  public void onCreate()
  {
    super.onCreate();
    Log.v("Pacemaker", "Pacemaker App Started");
  }
}
