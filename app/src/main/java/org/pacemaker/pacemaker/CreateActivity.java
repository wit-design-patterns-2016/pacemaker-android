package org.pacemaker.pacemaker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class CreateActivity extends AppCompatActivity
{
  private Button       createActivityButton;
  private TextView     activityType;
  private TextView     activityLocation;
  private NumberPicker distancePicker;

  private List<MyActivity> activities = new ArrayList<MyActivity>();

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_create);

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

    activities.add(activity);
    Log.v("Pacemaker", "CreateActivity Button Pressed with " + distance);
  }

  public void listActivityButtonPressed (View view)
  {
    Log.v("Pacemaker", "List Activities Button Pressed");
  }
}
