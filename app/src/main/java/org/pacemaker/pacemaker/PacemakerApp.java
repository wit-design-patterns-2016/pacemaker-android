package org.pacemaker.pacemaker;

import java.util.ArrayList;
import java.util.List;

import android.app.Application;
import android.util.Log;

public class PacemakerApp extends Application
{
  public List<MyActivity> actvities = new ArrayList<MyActivity>();

  @Override
  public void onCreate()
  {
    super.onCreate();
    Log.v("Pacemaker", "Pacemaker App Started");
  }
}