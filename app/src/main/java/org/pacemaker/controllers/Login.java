package org.pacemaker.controllers;

import org.pacemaker.R;
import org.pacemaker.main.PacemakerApp;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

public class Login extends Activity
{
  PacemakerApp app;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
  }

  public void signinPressed (View view) 
  {
    app = (PacemakerApp) getApplication();
    
    TextView email     = (TextView)  findViewById(R.id.loginEmail);
    TextView password  = (TextView)  findViewById(R.id.loginPassword);
    
    startActivity (new Intent(this, CreateActivity.class));
  }
}