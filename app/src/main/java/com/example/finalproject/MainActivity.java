package com.example.finalproject;
//Chris
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.text.Editable;
import android.widget.EditText;
import android.widget.TextView;
import android.text.TextWatcher;
import android.util.Log;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView, mRecyclerViewQuick, mRecyclerViewRecent;
    List<FoodData> myFoodList, myQuickList, myRecentList;
    FoodData mFoodData;
    TextView textViewName;
    MyAdapter myAdapter;
    EditText txt_Search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewName = findViewById(R.id.textViewUsername);
        String email =getIntent().getStringExtra("email");
        textViewName.setText(email);
        textViewName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = textViewName.getText().toString();
                Intent intent = new Intent(MainActivity.this, Logout.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("email", email);
                startActivity(intent);
            }
        });



//Popular menu recycler view
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        mRecyclerViewQuick = (RecyclerView)findViewById(R.id.recycleViewQuick);
        mRecyclerViewRecent = (RecyclerView)findViewById(R.id.recycleViewRecent);
//      GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this,1 );
//      mRecyclerView.setLayoutManager(gridLayoutManager);
        txt_Search = findViewById(R.id.txt_searchtext);

        myFoodList = new ArrayList<FoodData>();

        mFoodData = new FoodData("Frozen Zabaglione", "Ingredients: \n 6 large egg yolks \n 1 pinch salt \n white sugar \n  2/3 cup dry Marsala wine \n 1 cup cold heavy cream. \n \n Step by Step: \n Step 1 \n Whisk egg yolks, salt, sugar, and Marsala wine together in a metal mixing bowl. \n Step 2 \n Set the bowl over a medium-low heat, or over a double boiler. Hold the bowl with one hand using a towel or pot-holder, while whisking constantly with the other. Continue cooking until the mixture is very thick and reaches the ribbon stage, about 10 minutes. \n Step 3 \n Remove custard from heat and allow to cool completely, preferably over an ice bath, whisking occasionally, 20 to 30 minutes. \n Step 4 \n Pour cold heavy cream into another bowl and whisk until soft peaks form. Transfer into the cooled custard and gently fold everything together until just barely combined; do not overmix. \n Step 5 \n Transfer into an airtight container, cover the top with plastic wrap, and seal. Place in a freezer until firm, at least 4 hours, or up to overnight.", "4 hours", R.drawable.frozenzabaglione);
        myFoodList.add(mFoodData);
        mFoodData = new FoodData("Air Fryer Chicken", "Ingredients: \n 4 eaches skin-on, boneless chicken thighs\n 2 teaspoons extra-virgin olive oil \n 1 teaspoon smoked paprika \n ¾ teaspoon garlic powder \n ½ teaspoon salt \n ½ teaspoon ground black pepper. \n \n Step by Step: \n Step 1: Preheat an air fryer to 400 degrees F (200 degrees C). \n Step 2: Pat chicken thighs dry with a paper towel and brush the skin-side of each piece with olive oil. Place chicken thighs, skin-side down, in a single layer on a plate. \n Step 3: Combine smoked paprika, garlic powder, salt, and pepper in a bowl and sprinkle half the seasoning mixture evenly over the 4 chicken thighs. Turn thighs over and evenly sprinkle remaining seasoning mixture on top. Place chicken thighs in the air fryer basket in a single layer, skin-side up. \n Step 4: Fry in the preheated air fryer until chicken is brown and juices run clear, about 18 minutes. An instant-read thermometer inserted into the center should read at least 165 degrees F (74 degrees C). ", "1 hour", R.drawable.airfryer);
        myFoodList.add(mFoodData);
        mFoodData = new FoodData("Easy No-Bake Strawberry Ice Cream Cake", "Ingredients: \n 1 (10 inch) prepared angel food cake. \n 2 pints strawberry ice cream. \n 1 (8 ounce) container thawed frozen whipped topping. \n 6 large fresh strawberries, sliced. \n 1 sprig fresh mint, leaves picked. \n \n Step by Step: \n Step 1: Using a long serrated knife or bread knife, slice angel food cake into 3 equal horizontal layers. Place the bottom layer onto a freezer-proof plate. \n Step 2: Remove packaging from the ice cream and slice about 1-inch thick. Working quickly, place ice cream slices on the bottom cake layer, filling the gaps with ice cream and leaving the center unfilled. Lightly press the ice cream pieces together to form a solid layer the same size as the cake layer. \n Step 3: Frost the entire cake with whipped topping. Garnish with fresh strawberry slices and mint. Serve immediately.", "1.5 hour", R.drawable.easy);
        myFoodList.add(mFoodData);
        mFoodData = new FoodData("Grilled Italian Sausage with Peppers and Onions", "Ingredients: \n 1 red bell pepper, cut into strips. \n 1 green bell pepper, cut into strips. \n 1 yellow bell pepper, cut into strips. \n 1 small white onion, sliced into petals. \n 1 small red onion, sliced into petals. \n 1 tablespoon olive oil. \n 1 teaspoon dried Italian seasoning. \n ½ teaspoon dried Italian seasoning. \n \n Step by Step: \n Step 1: Preheat an outdoor grill for medium-high heat and lightly oil the grate. \n Step 2: Combine bell peppers and onions in a large bowl. Add olive oil, Italian seasoning, salt, and pepper. Stir to combine. Using a toothpick, poke 4 holes into each sausage to prevent them from exploding on the grill. \n Step 3: Place vegetables in a grill basket and cook for 2 minutes. Add sausage directly to the grate and grill for 4 minutes. Flip sausage over, stir vegetables, and grill for 4 minutes more.", "35 mins", R.drawable.grilled);
        myFoodList.add(mFoodData);
        mFoodData = new FoodData("Sourdough Blueberry Muffins", "Ingredients: \n 1 cup fresh blueberries. \n 2 teaspoons all-purpose flour. \n 1 teaspoon baking soda. \n 1 teaspoon ground cinnamon. \n ¼ teaspoon salt. \n 1 cup sourdough starter, at room temperature. \n ¼ cup white sugar. \n 1 egg. \n ¼ cup unsalted butter, melted and cooled. \n 1 teaspoon vanilla extract. \n \n Step by Step: \n Step 1: Preheat the oven to 375 degrees F (190 degrees C). Line 10 muffin cups with paper liners. \n Step 2: Combine blueberries and 2 teaspoons flour and toss to coat. \n Step 3: Combine 1 cup flour, baking soda, cinnamon, and salt in a bowl. Whisk sourdough starter, sugar, egg, melted butter, and vanilla extract together in a second bowl. \n Step 4: Spoon batter evenly into the prepared muffin cups. \n Step 5: Combine sugar, flour, butter, and cinnamon for the topping in a bowl and mix with a fork until crumbly. Sprinkle topping over the muffins. \n Step 6: Bake in the preheated oven until tops spring back when lightly pressed and a toothpick comes out clean, 20 to 22 minutes. Cool in the pan for 10 minutes.", "45 mins", R.drawable.sourdough);
        myFoodList.add(mFoodData);
        mFoodData = new FoodData("Butter Swim Biscuits", "Ingredients: \n ½ cup unsalted butter. \n 2 ½ cups all-purpose flour. \n 4 teaspoons baking powder. \n 4 teaspoons white sugar. \n 1 teaspoon salt. 1 ¾ cups buttermilk. \n \n Step by Step: \n Step 1: Preheat the oven to 450 degrees F (230 degrees C). \n Step 2: Place butter in an 8x8-inch glass or ceramic baking dish. Microwave for 1 minute. Stir butter and keep microwaving at 20-second intervals until butter is fully melted. \n Step 3: Sift flour, baking powder, sugar, and salt into a bowl. Add buttermilk and stir until combined. Pour over melted butter and spread over the melted butter. Use a bench scraper to cut dough into 9 equal pieces. \n Step 4: Bake in the preheated oven until biscuit tops start to brown, 20 to 25 minutes.", "50 mins", R.drawable.butterswimbiscuits);
        myFoodList.add(mFoodData);

        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        //MyAdapter myAdapter = new MyAdapter(MainActivity.this, myFoodList);
        myAdapter = new MyAdapter(MainActivity.this, myFoodList);
        mRecyclerView.setAdapter(myAdapter);

        //Quick Menu recyclerView

        myQuickList = new ArrayList<>();
        mFoodData = new FoodData("Simple Macaroni and Cheese", "A very quick and easy fix to a tasty side-dish. Fancy, designer mac and cheese often costs forty or fifty dollars to prepare when you have so many exotic and expensive cheeses, but they aren't always the best tasting.\n\n 1 (8 ounce) box elbow macaroni\n¼ cup butter\n¼ cup all-purpose flour\n½ teaspoon salt\nGround black pepper to taste\n2 cups milk\n2 cups shredded Cheddar cheese.\n\nStep by Step:\nStep 1: Bring a large pot of lightly salted water to a boil. Cook elbow macaroni in the boiling water, stirring occasionally until cooked through but firm to the bite, 8 minutes. Drain.\nStep 2: Melt butter in a saucepan over medium heat; stir in flour, salt, and pepper until smooth, about 5 minutes. Slowly pour milk into butter-flour mixture while continuously stirring until mixture is smooth and bubbling, about 5 minutes. Add Cheddar cheese to milk mixture and stir until cheese is melted, 2 to 4 minutes.\nStep 3:Fold macaroni into cheese sauce until coated.","20 mins", R.drawable.simplemacaroni);
        myQuickList.add(mFoodData);
        mFoodData = new FoodData("One Pot Thai-Style Rice Noodles", "Chicken, vegetables, and noodles prepared in a light tasting but full-flavored Asian-inspired.\n2tablespoons cornstarch\n1 ½ tablespoons water\n6 cups chicken broth\n2 ½ tablespoons soy sauce\n1 tablespoon fish sauce\n1 tablespoon rice vinegar\n1 tablespoon chile-garlic sauce (such as Sriracha®), or more to taste.\n\nStep by Step:\nStep 1:\nStir cornstarch and water together in a small bowl until smooth. Pour chicken broth into a large pot and stir cornstarch mixture, soy sauce, fish sauce, rice vinegar, chile-garlic sauce, vegetable oil, ginger, garlic, and coriander into broth. Cover and bring to a boil.\nStep 2: Place rice noodles in the boiling sauce, reduce heat to medium, and simmer until noodles are tender, 5 to 10 minutes. Stir zucchini, red bell pepper, and chicken into sauce. Bring back to a boil, cover, and simmer until vegetables are just become tender, about 5 more minutes.\nStep 3: Remove from heat and let stand, covered, for 5 minutes to thicken. Serve garnished with crushed peanuts and cilantro.","15 mins", R.drawable.onepotthat);
        myQuickList.add(mFoodData);
        mFoodData = new FoodData("Five-Ingredient Red Curry Chicken","Five-ingredient red curry chicken with noodles is easy, quick, and inexpensive to make. Sweetened with coconut milk for unbelievable flavor!\n2 tablespoons coconut oil\n1 (16 ounce) package skinless, boneless chicken breast halves, cut into small cubes\n1 (14 ounce) can cream of coconut (such as Trader Joe's® Extra Thick and Rich)\n1 (11 ounce) bottle red Thai curry sauce (such as Trader Joe's®)\\n½ (16 ounce) package dried rice stick vermicelli noodles\n\nStep by Step:\nStep 1: Heat oil in a large skillet on high heat. Add chicken cubes; cook until browned, about 2 minutes per side. Reduce heat to medium-high and add coconut cream and curry sauce. Cook until chicken is no longer pink in the center and the juices run clear, about 5 minutes. An instant-read thermometer inserted into the center should read at least 165 degrees F (74 degrees C).\nStep 2: Fill a large pot with lightly salted water and bring to a rolling boil; stir in vermicelli pasta and return to a boil. Cook pasta uncovered, stirring occasionally, until the pasta is tender yet firm to the bite, 4 to 5 minutes. Drain.\nStep 3: Reduce skillet heat to simmer. Add the noodles and let simmer until flavors are absorbed, about 5 minutes. Divide chicken and noodles among individual serving bowls.","20 mins", R.drawable.fiveingre);
        myQuickList.add(mFoodData);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL, false);
        mRecyclerViewQuick.setLayoutManager(layoutManager2);
        MyAdapter myAdapter2 = new MyAdapter(MainActivity.this, myQuickList);
        mRecyclerViewQuick.setAdapter(myAdapter2);

        //Recent menu
        myRecentList = new ArrayList<>();
        mFoodData = new FoodData("Spatchcock Chicken", "Spatchcocking makes for a bird with super crisp skin and moist meat, in about half the time it takes to roast a whole bird.\n\n2 (3 1/2) pound whole chickens, wingtips removed\n2 teaspoons salt\n1 teaspoon dried tarragon\n1 teaspoon paprika\n¼ teaspoon black pepper.\n\nStep by Step\nStep 1: Preheat oven to 450 degrees F (230 degrees C). Line a large rimmed baking sheet with foil.\nStep 2: Place chicken, breast side down, on a work surface.\nStep 3: Combine salt, tarragon, paprika, and pepper in a small bowl. Stir in oil. Run your fingers under chicken skin and rub tarragon paste under skin. Slide lemon slices under skin, in a single layer.\nStep 4: Roast until skin is crisp and an instant-read thermometer inserted into thickest part of breast reads 165 degrees F, about 35 minutes.","35 mins", R.drawable.spatchcock);
        myRecentList.add(mFoodData);
        mFoodData = new FoodData("Skillet Chicken Bulgogi", "This is a quick and easy, but very tasty meal. You can substitute the chicken with beef or pork for variety.\n¼ cup chopped onion\n5 tablespoons soy sauce\n2 ½ tablespoons brown sugar\n2 tablespoons minced garlic\n2 tablespoons sesame oil.\n\nStep by Step:\nStep 1: Whisk onion, soy sauce, brown sugar, garlic, sesame oil, sesame seeds, cayenne pepper, salt, and black pepper together in a bowl until marinade is smooth.\nStep 2: Cook and stir chicken and marinade together in a large skillet over medium-high heat until chicken is cooked through, about 15 minutes.", "15 mins", R.drawable.skilletchicken);
        myRecentList.add(mFoodData);
        mFoodData = new FoodData("Perfect Ten Baked Cod","Simple, fast, and delicious describes this baked cod recipe. Bake for two sets of 10 minutes each and you have the perfect ten dinner!\n2 tablespoons butter\n½ sleeve buttery round crackers (such as Ritz®), crushed\n2 tablespoons butter\n1 pound thick-cut cod loin.\n\nStep by Step:\nStep 1: Preheat oven to 400 degrees F (200 degrees C).\nStep 2: Place 2 tablespoons butter in a microwave-safe bowl; melt in microwave on high, about 30 seconds. Stir buttery round crackers into melted butter.\nStep 3: Place remaining 2 tablespoons butter in a 7x11-inch baking dish. Melt in the preheated oven, 1 to 3 minutes. Remove dish from oven.\nStep 4: Coat both sides of cod in melted butter in the baking dish.","30 mins",R.drawable.perfectten);
        myRecentList.add(mFoodData);
        LinearLayoutManager layoutManager3 = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL, false);
        mRecyclerViewRecent.setLayoutManager(layoutManager3);
        MyAdapter myAdapter3 = new MyAdapter(MainActivity.this, myRecentList);
        mRecyclerViewRecent.setAdapter(myAdapter3);

        txt_Search.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d("Food","This is TextChanged");
                String txt_searchtext = txt_Search.getText().toString();
                filter(txt_searchtext);

            }
        });

    }
    private void filter(String text) {
        ArrayList<FoodData> filterList = new ArrayList<>();
        Log.d("Food", "This is running!");

        for(FoodData itemName: myFoodList){
            if(itemName.getItemName().toLowerCase().contains(text.toLowerCase())){
                filterList.add(itemName);
                Log.d("Food", "The item: "+itemName.getItemName()+" is added!");
            }
            else{
                Log.d("Food","Not found");
            }
        }
        for(FoodData itemName: myQuickList){
            if(itemName.getItemName().toLowerCase().contains(text.toLowerCase())){
                filterList.add(itemName);
                Log.d("Food", "The item: "+itemName.getItemName()+" is added!");
            }
            else{
                Log.d("Food","Not found");
            }
        }
        for(FoodData itemName: myRecentList){
            if(itemName.getItemName().toLowerCase().contains(text.toLowerCase())){
                filterList.add(itemName);
                Log.d("Food", "The item: "+itemName.getItemName()+" is added!");
            }
            else{
                Log.d("Food","Not found");
            }
        }
        // new
        if (filterList.size()>0){
            Log.d("Food",filterList.toString());
            myAdapter.filteredList(filterList);
        }

    }

}