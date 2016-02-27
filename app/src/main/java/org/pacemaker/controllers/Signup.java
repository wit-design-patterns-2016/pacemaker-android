package org.pacemaker.controllers;

import org.pacemaker.R;
import org.pacemaker.main.PacemakerApp;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

public class Signup extends Activity 
{
  private PacemakerApp app;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_signup);
    app = (PacemakerApp) getApplication();
  }

  public void registerPressed (View view) 
  {
    TextView firstName = (TextView)  findViewById(R.id.firstName);
    TextView lastName  = (TextView)  findViewById(R.id.lastName);
    TextView email     = (TextView)  findViewById(R.id.Email);
    TextView password  = (TextView)  findViewById(R.id.Password);

    startActivity (new Intent(this, Login.class));
  }
}
