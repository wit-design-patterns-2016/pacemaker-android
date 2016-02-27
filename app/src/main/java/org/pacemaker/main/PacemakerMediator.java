package org.pacemaker.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.pacemaker.http.Response;
import org.pacemaker.models.MyActivity;
import org.pacemaker.models.MyActivity;
import org.pacemaker.models.User;

import android.content.Context;
import android.widget.Toast;

public class PacemakerMediator
{
  Context                     context;
  SyncUpdate                  syncUpdate;
  Map<String, User>           users             = new HashMap<String, User>();
  Map<String, List<MyActivity>> activities      = new HashMap<String, List<MyActivity>>();
  UserResponder               userResponder     = new UserResponder(this);
  ActivityResponder           activityResponder = new ActivityResponder(this);  
  
  public User getUser(String email)
  {
    return users.get(email);
  }
  
  public List<MyActivity> getActivities(User user)
  {
    return activities.get(user.email);
  }
  
  public void registerUser(Context context, User user, SyncUpdate syncUpdate)
  { 
    this.syncUpdate = syncUpdate;
    PacemakerAPI.createUser(context, userResponder, "Creating new User...", user);
  }
  
  public void createActivity(User user, MyActivity activity, SyncUpdate syncUpdate)
  {
    this.syncUpdate = syncUpdate;
    PacemakerAPI.createActivity(context, user, activityResponder, "Creating new Activity...", activity);
  }
  
  void syncUsers(Context context, SyncUpdate syncUpdate)
  {
    this.context    = context;
    this.syncUpdate = syncUpdate;
    PacemakerAPI.getUsers(context, userResponder, "Syncing Users");
  }
  
  void syncActivities(User user, SyncUpdate syncUpdate)
  {
    this.syncUpdate = syncUpdate;
    activityResponder.user = user;
    PacemakerAPI.getActivities(context, user, activityResponder, "Syncing Activities");   
  }

  void error(Exception e)
  {
    Toast toast = Toast.makeText(context, "Error in communicating with Pacemaker", Toast.LENGTH_SHORT);
    toast.show();
  }
}

class UserResponder implements Response<User>
{
  PacemakerMediator mediator;
  
  UserResponder (PacemakerMediator pacemakerMediator)
  {
    this.mediator = pacemakerMediator;   
  }
   
  @Override
  public void setResponse(List<User> users)
  {
    for (User user : users)
    {
      mediator.users.put(user.email, user);
    }
    mediator.syncUpdate.userSyncComplete();
  }

  @Override
  public void setResponse(User user)
  {
    mediator.users.put(user.email, user);
    mediator.activities.put(user.email, new ArrayList<MyActivity>());
    mediator.syncUpdate.userSyncComplete();
  }

  @Override
  public void errorOccurred(Exception e)
  {
    mediator.error(e);
  }
}

class ActivityResponder implements Response<MyActivity>
{
  PacemakerMediator mediator;
  User              user;
  
  ActivityResponder (PacemakerMediator mediator)
  {
    this.mediator = mediator;   
  }
  
  @Override
  public void setResponse(List<MyActivity> activities)
  {
    mediator.activities.put(user.email, activities);
    mediator.syncUpdate.activitiesSyncComplete();
  }

  @Override
  public void setResponse(MyActivity activity)
  {
    mediator.activities.get(user.email).add(activity);
    mediator.syncUpdate.activitiesSyncComplete();
  }

  @Override
  public void errorOccurred(Exception e)
  {
    mediator.error(e);
  }
}
