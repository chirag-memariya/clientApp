 package com.example.clientapp;

 import static com.example.clientapp.data.getFireBaseData;

 import androidx.activity.result.ActivityResultLauncher;
 import androidx.annotation.NonNull;
 import androidx.appcompat.app.AppCompatActivity;
 import androidx.appcompat.widget.Toolbar;
 import androidx.recyclerview.widget.DividerItemDecoration;
 import androidx.recyclerview.widget.LinearLayoutManager;
 import androidx.recyclerview.widget.LinearSnapHelper;
 import androidx.recyclerview.widget.RecyclerView;
 import androidx.recyclerview.widget.SnapHelper;


 import android.content.Intent;
 import android.os.Bundle;
 import android.view.Menu;
 import android.view.MenuInflater;
 import android.view.MenuItem;
 import android.view.MotionEvent;
 import android.view.View;
 import android.view.animation.Animation;
 import android.view.animation.AnimationUtils;
 import android.widget.TextView;
 import android.widget.Toast;

 import com.google.firebase.database.DataSnapshot;
 import com.google.firebase.database.DatabaseError;
 import com.google.firebase.database.DatabaseReference;
 import com.google.firebase.database.FirebaseDatabase;
 import com.google.firebase.database.Query;
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





  //^^^^


  ////    public static ArrayList<data> createdatasList(int numdatas) {
  ////        ArrayList<data> datas = new ArrayList<data>();
  ////        datas.add(new data("Vehicle1",true));
  //
  //
  ////        for (int i = 1; i <= numdatas; i++) {
  ////            datas.add(new data("Eva Mall " + ++lastdataId, i <= numdatas / 2));
  ////        }




 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_wallet_upadate);


 //add money text view
  addMoney=findViewById(R.id.addMoney);
  scaleUp= AnimationUtils.loadAnimation(this,R.anim.scale_up);

  scaleDown=AnimationUtils.loadAnimation(this,R.anim.scale_down);

  textViewBalance=findViewById(R.id.textViewBalance);

  //set real database balance to the textViewBalance


  DatabaseReference reference1 = FirebaseDatabase.getInstance().getReference("User");
  Query checkUserDatabase1 = reference1.equalTo("kasl");
  checkUserDatabase1.addValueEventListener(new ValueEventListener() {
                                           @Override
                                           public void onDataChange(@NonNull DataSnapshot snapshot) {

                                            for(DataSnapshot snapshot1:snapshot.getChildren()) {
                                             String mWalletMoney=snapshot1.child("wallet").getValue(String.class);
//                                             numberPlate = snapshot1.child("vehiclePlateNo").getValue(String.class);
//                                             inTime = snapshot1.child("inTime").getValue(String.class);
//                                             outTime = snapshot1.child("outTime").getValue(String.class);
                                             //   int tmpFee = snapshot1.child("fee").getValue(Integer.class);
                                             //    fees=Integer.toString(tmpFee);
//                                             arrNumber.add(new LogsModel(numberPlate, "fees", inTime, outTime));
                                             // System.out.println(numberPlate + "\n" + fees + "\n" + inTime + "\n" + outTime);
                                             textViewBalance.setText(mWalletMoney);

                                            }
                                           }

                                           @Override
                                           public void onCancelled(@NonNull DatabaseError error) {

                                           }});


                                           //firebase
  FirebaseDatabase firebaseDatabase;
  firebaseDatabase = FirebaseDatabase.getInstance();

  DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference().child("programing knowladge");

//  setData(databaseReference,textViewBalance);

  /*
  Continue.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View view) {
    String added_amoount=editTextAddAmount.getText().toString();
    int editAmount=Integer.parseInt(added_amoount);
    if(added_amoount.isEmpty()){
     Toast.makeText(add_balance.this, "Please Enter a Amount!!", Toast.LENGTH_SHORT).show();
    }else{
     //set data
                    /*
                    DatabaseReference databaseReference1=FirebaseDatabase.getInstance().getReference().child("programing knowladge");
                    databaseReference1.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            int value = snapshot.child("amt").getValue(Integer.class);  //-->>>> retrieved from  database

                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(getApplicationContext(), "Fail to get data.", Toast.LENGTH_SHORT).show();
                        }
                    });
     FirebaseDatabase.getInstance().getReference("programing knowladge").child("amt").setValue(arr[0]+editAmount);
     Toast.makeText(add_balance.this, "Rs. "+added_amoount+" added", Toast.LENGTH_SHORT).show();
     finish();


    }
   }
  }); */

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
    startActivity(intent);
   }
  });







  //^^^^^^Transaction Loading

 //recycler view
 // Lookup the recyclerview in activity layout
 RecyclerView recyclerViewData=(RecyclerView) findViewById(R.id.rvdatas) ;

 // Initialize data

// datas = data.createdatasList(20);

  DatabaseReference reference = FirebaseDatabase.getInstance().getReference("VehicleHistory");
  Query checkUserDatabase = reference.orderByChild("transactionId");
  datas=getFireBaseData(checkUserDatabase);

 // Create adapter passing in the sample user data
 DataAdapter adapter = new DataAdapter(datas);
 // Attach the adapter to the recyclerview to populate items
 recyclerViewData.setAdapter(adapter);
 // Set layout manager to position the items
 recyclerViewData.setLayoutManager(new LinearLayoutManager(this));
 // That's all!

// datas.addAll(data.createdatasList(5));

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
  private void setData(@NonNull DatabaseReference databaseReference, TextView tbalance){
   databaseReference.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange( DataSnapshot snapshot) {
     int value = snapshot.child("amt").getValue(Integer.class);
     tbalance.setText("Rs "+value);
    }
    @Override
    public void onCancelled(@NonNull DatabaseError error) {
     Toast.makeText(getApplicationContext(), "Fail to get data.", Toast.LENGTH_SHORT).show();
    }
   });
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
