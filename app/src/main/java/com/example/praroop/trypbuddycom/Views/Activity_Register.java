package com.example.praroop.trypbuddycom.Views;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.praroop.trypbuddycom.R;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

public class Activity_Register extends AppCompatActivity implements View.OnClickListener {
    TextView tv_skip;
    LoginButton loginButton;
    CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__register);
        try {
            PackageInfo info = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String hashKey = new String(Base64.encode(md.digest(), 0));
                Toast.makeText(this, hashKey, Toast.LENGTH_SHORT).show();

            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();
        }
        loginButton = findViewById(R.id.login_button);
        boolean loggedOut = AccessToken.getCurrentAccessToken() == null;
        tv_skip = (TextView) findViewById(R.id.tv_skip);
        tv_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity_Register.this, Activity_Main.class);
                startActivity(i);
            }
        });
        if (!loggedOut) {
           /* Picasso.with(this).load(Profile.getCurrentProfile().getProfilePictureUri(200, 200)).into(imageView);
            Log.d("TAG", "Username is: " + Profile.getCurrentProfile().getName());

            //Using Graph API
            getUserProfile(AccessToken.getCurrentAccessToken());*/
        }


        AccessTokenTracker fbTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken accessToken, AccessToken accessToken2) {
                if (accessToken2 == null) {
                  /*  txtUsername.setText(null);
                    txtEmail.setText(null);
                    imageView.setImageResource(0);*/
                    Toast.makeText(getApplicationContext(), "User Logged Out.", Toast.LENGTH_LONG).show();
                }
            }
        };
        fbTracker.startTracking();

        loginButton.setReadPermissions(Arrays.asList("email", "public_profile"));
        callbackManager = CallbackManager.Factory.create();

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
                //loginResult.getAccessToken();
                //loginResult.getRecentlyDeniedPermissions()
                //loginResult.getRecentlyGrantedPermissions()
                boolean loggedOut = AccessToken.getCurrentAccessToken() == null;

                if (!loggedOut) {
                   // Picasso.with(Activity_Register.this).load(Profile.getCurrentProfile().getProfilePictureUri(200, 200)).into(imageView);
                    Log.d("TAG", "Username is: " + Profile.getCurrentProfile().getName());
                    Toast.makeText(Activity_Register.this, Profile.getCurrentProfile().getName(), Toast.LENGTH_SHORT).show();
                    //Using Graph API
                    getUserProfile(AccessToken.getCurrentAccessToken());
                    Intent i = new Intent(Activity_Register.this, Activity_Main.class);
                    startActivity(i);
                }

            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void getUserProfile(AccessToken currentAccessToken) {
        GraphRequest request = GraphRequest.newMeRequest(
                currentAccessToken, new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        Log.d("TAG", object.toString());
                        try {
                            Toast.makeText(Activity_Register.this, object.toString(), Toast.LENGTH_SHORT).show();
                            String first_name = object.getString("first_name");
                            String last_name = object.getString("last_name");
                            String email = object.getString("email");
                            String id = object.getString("id");
                            String image_url = "https://graph.facebook.com/" + id + "/picture?type=normal";



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });

        Bundle parameters = new Bundle();
        parameters.putString("fields", "first_name,last_name,email,id");
        request.setParameters(parameters);
        request.executeAsync();

    }

    @Override
    public void onClick(View view) {

    }
}
