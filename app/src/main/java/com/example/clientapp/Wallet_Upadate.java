 package com.example.clientapp;

 import androidx.activity.result.ActivityResult;
 import androidx.activity.result.ActivityResultCallback;
 import androidx.activity.result.ActivityResultLauncher;
 import androidx.activity.result.contract.ActivityResultContracts;
 import androidx.annotation.NonNull;
 import androidx.appcompat.app.AppCompatActivity;
 import androidx.appcompat.widget.Toolbar;
 import androidx.recyclerview.widget.DividerItemDecoration;
 import androidx.recyclerview.widget.LinearLayoutManager;
 import androidx.recyclerview.widget.LinearSnapHelper;
 import androidx.recyclerview.widget.RecyclerView;
 import androidx.recyclerview.widget.SnapHelper;


 import android.animation.Animator;
 import android.annotation.SuppressLint;
 import android.app.Instrumentation;
 import android.content.Intent;
 import android.os.Bundle;
 import android.view.Menu;
 import android.view.MenuInflater;
 import android.view.MenuItem;
 import android.view.MotionEvent;
 import android.view.View;
 import android.view.animation.Animation;
 import android.view.animation.AnimationUtils;
 import android.widget.Button;
 import android.widget.TextView;
 import android.widget.Toast;

 import com.google.firebase.database.DataSnapshot;
 import com.google.firebase.database.DatabaseError;
 import com.google.firebase.database.DatabaseReference;
 import com.google.firebase.database.FirebaseDatabase;
 import com.google.firebase.database.ValueEventListener;

 import java.util.ArrayList;

 import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

 public class Wallet_Upadate extends AppCompatActivity {

 ArrayList<data> datas;



 Toolbar toolbar;

 //text add money button
  TextView addMoney;
  TextView textViewBalance;
  Animation scaleUp,scaleDown;

  ActivityResultLauncher<Intent> activityResultLauncher;



 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_wallet_upadate);


 //add money text view
  addMoney=findViewById(R.id.addMoney);
  scaleUp= AnimationUtils.loadAnimation(this,R.anim.scale_up);


  scaleDown=AnimationUtils.loadAnimation(this,R.anim.scale_down);


  textViewBalance=findViewById(R.id.textViewBalance);
  //##// firebase
  // creating a variable for
  // our Firebase Database.
  FirebaseDatabase firebaseDatabase;

  // creating a variable for our
  // Database Reference for Firebase.
  DatabaseReference databaseReference;
  firebaseDatabase = FirebaseDatabase.getInstance();

  // below line is used to get
  // reference for our database.
  databaseReference = firebaseDatabase.getReference("Balance");

  ///--here
  int total_balance=30;
//  total_balance=setData(databaseReference,textViewBalance);







  addMoney.setOnTouchListener(new View.OnTouchListener() {
   @Override
   public boolean onTouch(View view, MotionEvent motionEvent) {
    if(motionEvent.getAction()==MotionEvent.ACTION_UP){
     addMoney.startAnimation(scaleUp);

    } else if (motionEvent.getAction()==MotionEvent.ACTION_DOWN) {
     addMoney.startAnimation(scaleDown);
    }
    return false;
   }
  });

  addMoney.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View view) {


    Intent intent=new Intent(getApplicationContext(),add_balance.class);
//    Bundle bundle=new Bundle();
//    bundle.putInt("number1",10);
//
//    intent.putExtras(bundle);
    startActivity(intent);
   }
  });

//  activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
//   @Override
//   public void onActivityResult(ActivityResult result) {
//    if (result.getResultCode()== RESULT_OK)
//    {
//     Intent intent = result.getData();
//     int added = intent.getIntExtra("added", -1);
//     Toast.makeText(getApplicationContext(), added+" money added", Toast.LENGTH_SHORT).show();
//    }
//   }
//  });







  //button touched
//  btn1=findViewById(R.id.message_button);






 //recycler view
 // Lookup the recyclerview in activity layout
 RecyclerView recyclerViewData=(RecyclerView) findViewById(R.id.rvdatas) ;

 // Initialize data
 datas = data.createdatasList(20);

 // Create adapter passing in the sample user data
 DataAdapter adapter = new DataAdapter(datas);
 // Attach the adapter to the recyclerview to populate items
 recyclerViewData.setAdapter(adapter);
 // Set layout manager to position the items
 recyclerViewData.setLayoutManager(new LinearLayoutManager(this));
 // That's all!

 datas.addAll(data.createdatasList(5));

 // Add a new contact
// datas.add(0, new data("Barney", true));
// // Notify the adapter that an item was inserted at position 0
// adapter.notifyItemInserted(0);


 RecyclerView.ItemDecoration itemDecoration = new
 DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
 recyclerViewData.addItemDecoration(itemDecoration);

 recyclerViewData.setItemAnimator(new SlideInUpAnimator());

 //Handling Touch Events
 recyclerViewData.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {

 @Override
 public boolean onInterceptTouchEvent(RecyclerView recycler, MotionEvent event) {
 return false;
 }

 @Override
 public void onTouchEvent(RecyclerView recycler, MotionEvent event) {
 Toast.makeText(getApplicationContext(),event.getDeviceId()+"touched",Toast.LENGTH_SHORT).show();
 }

 @Override
 public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

 }
 });

 SnapHelper snapHelper = new LinearSnapHelper();
 snapHelper.attachToRecyclerView(recyclerViewData);



 //make toast





 //toolbar
 //step -1
 toolbar=findViewById(R.id.toolbar);
 setSupportActionBar(toolbar);


 //step -2
 //        if(getSupportActionBar()!=null){
 getSupportActionBar().setDisplayHomeAsUpEnabled(true);
 getSupportActionBar().setTitle("WalletPage");
 //        }
 }



  //for read data into a firebase
  private int setData(@NonNull DatabaseReference databaseReference, TextView tbalance){

   int[] total_balance = {0};
   databaseReference.addValueEventListener(new ValueEventListener() {
    @SuppressLint("SetTextI18n")
    @Override
    public void onDataChange(@NonNull DataSnapshot snapshot) {
     // this method is call to get the realtime
     // updates in the data.
     // this method is called when the data is
     // changed in our Firebase console.
     // below line is for getting the data from
     // snapshot of our database.
     int value = Integer.parseInt(snapshot.getValue(String.class));  //-->>>> retrieved from  database
     // after getting the value we are setting
     // our value to our text view in below line.
     total_balance[0] =value;
     tbalance.setText(value);
//              Toast.makeText(add_balance.this, "Rs. "+value+" added", Toast.LENGTH_SHORT).show();
    }







    @Override
    public void onCancelled(@NonNull DatabaseError error) {
     // calling on cancelled method when we receive
     // any error or we are not able to get the data.
     Toast.makeText(getApplicationContext(), "Fail to get data.", Toast.LENGTH_SHORT).show();
    }
   });
   return total_balance[0];
  }

 //option menu

 @Override
 public boolean onCreateOptionsMenu(Menu menu) {
 new MenuInflater(this).inflate(R.menu.menu,menu);
 return super.onCreateOptionsMenu(menu);
 }

 @Override
 public boolean onOptionsItemSelected(@NonNull MenuItem item) {
 int itemID=item.getItemId();

 if(itemID==R.id.newbtn){
 Toast.makeText(getApplicationContext(),"New File is Created",Toast.LENGTH_SHORT).show();
 }
 else if(itemID==R.id.edit){
 Toast.makeText(getApplicationContext(),"File Edit",Toast.LENGTH_SHORT).show();

 }
 else if(itemID==R.id.save){
 Toast.makeText(getApplicationContext(),"File Saved",Toast.LENGTH_SHORT).show();
 }
 else{
 super.onBackPressed();
 }

 return super.onOptionsItemSelected(item);
 }
 }
