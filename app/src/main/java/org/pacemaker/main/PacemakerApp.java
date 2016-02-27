package org.pacemaker.main;

import java.util.List;
import org.pacemaker.models.MyActivity;
import org.pacemaker.models.User;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class PacemakerApp extends Application implements  SyncUpdate
{
  private User              loggedInUser;
  private PacemakerMediator mediator = new PacemakerMediator();

  public void syncUsers(Context context)
  {
    mediator.syncUsers(context, this);
  }

  public void registerUser(User user, Context context)
  {
    mediator.registerUser(context, user, this);
  }

  public List<MyActivity> getActivities()
  {
    return mediator.getActivities(loggedInUser);
  }

  public boolean loginUser(String email, String password)
  {
    loggedInUser = mediator.getUser(email);
    if (loggedInUser != null && !loggedInUser.password.equals(password))
    {
      loggedInUser = null;
    }
    mediator.syncActivities(loggedInUser, this);
    return loggedInUser != null;
  }

  public void logout()
  {
    loggedInUser = null;
  }

  public void createActivity (Context context, MyActivity activity, SyncUpdate syncUpdate)
  {
    if (loggedInUser != null)
    {
      mediator.createActivity(loggedInUser, activity, syncUpdate);
    }
  }

  @Override
  public void userSyncComplete()
  {
    Toast toast = Toast.makeText(this, "Pacemaker Sync Successful", Toast.LENGTH_SHORT);
    toast.show();
  }

  @Override
  public void activitiesSyncComplete()
  {
    Toast toast = Toast.makeText(this, "Pacemaker Sync Successful", Toast.LENGTH_SHORT);
    toast.show();
  }

  @Override
  public void syncError(Exception e)
  {
    Toast toast = Toast.makeText(this, "Failed to connect to Pacemaker Service", Toast.LENGTH_SHORT);
    toast.show();
  }

  @Override
  public void onCreate()
  {
    super.onCreate();
    Log.v("Pacemaker", "Pacemaker App Started");
  }
}

