package org.pacemaker.main;

import java.util.ArrayList;
import java.util.List;

import android.app.Application;
import android.util.Log;
import org.pacemaker.models.MyActivity;

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