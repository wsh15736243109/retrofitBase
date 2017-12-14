package myretrofitrequest.wsh.com.myretrofitrequest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.Observable;
import java.util.Observer;

import myretrofitrequest.wsh.com.myretrofitrequest.retrofit.base.ResultEntity;
import myretrofitrequest.wsh.com.myretrofitrequest.retrofit.presenter.UserPrestener;

public class MainActivity extends AppCompatActivity implements Observer {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void testLogin(View view){
        UserPrestener userPrestener=new UserPrestener(this);
        userPrestener.login2("15736243109","123456","+86");
    }

    @Override
    public void update(Observable observable, Object o) {
        ResultEntity resultEntity= (ResultEntity) o;
        Toast.makeText(MainActivity.this,resultEntity.getData().toString()+"",Toast.LENGTH_SHORT).show();
    }
}
