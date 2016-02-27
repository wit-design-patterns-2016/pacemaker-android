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
  public List<MyActivity> activities = new ArrayList<MyActivity>();
  public Map<String, User> users     = new HashMap<String, User>();

  @Override
  public void onCreate()
  {
    super.onCreate();
    Log.v("Pacemaker", "Pacemaker App Started");
  }
}