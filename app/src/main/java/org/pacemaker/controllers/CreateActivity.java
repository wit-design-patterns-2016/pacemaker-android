package org.pacemaker.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import org.pacemaker.main.PacemakerApp;
import org.pacemaker.models.MyActivity;
import java.util.ArrayList;
import java.util.List;
import org.pacemaker.R;

public class CreateActivity extends AppCompatActivity
{
  private PacemakerApp app;

  private Button       createActivityButton;
  private TextView     activityType;
  private TextView     activityLocation;
  private NumberPicker distancePicker;

  private ArrayList<MyActivity> activities = new ArrayList<MyActivity>();

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_create);

    app = (PacemakerApp) getApplication();

    createActivityButton = (Button)       findViewById(R.id.createActivityButton);
    activityType         = (TextView)     findViewById(R.id.activityType);
    activityLocation     = (TextView)     findViewById(R.id.activityLocation);
    distancePicker       = (NumberPicker) findViewById(R.id.numberPicker);

    distancePicker.setMinValue(0);
    distancePicker.setMaxValue(20);

    Log.v("Pacemaker", "got the CreateActivity button");
  }

  public void createActivityButtonPressed (View view)
  {
    double distance = distancePicker.getValue();
    MyActivity activity = new MyActivity (activityType.getText().toString(), activityLocation.getText().toString(), distance);

    app.createActivity(activity);
    Log.v("Pacemaker", "CreateActivity Button Pressed with " + distance);
  }


  public void listActivityButtonPressed (View view)
  {
    Log.v("Pacemaker", "List Activityies Button Pressed");
    Intent intent = new Intent(this, ActivitiesList.class);
    startActivity (intent);
  }
}
