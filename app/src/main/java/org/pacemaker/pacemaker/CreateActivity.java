package org.pacemaker.pacemaker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class CreateActivity extends AppCompatActivity
{
  private Button createActivityButton;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_create);

    createActivityButton = (Button) findViewById(R.id.createActivityButton);

    Log.v("Pacemaker", "got the CreateActivity button");
  }

  public void createActivityButtonPressed (View view)
  {
    Log.v("Pacemaker", "CreateActivity Button Pressed!");
  }
}
