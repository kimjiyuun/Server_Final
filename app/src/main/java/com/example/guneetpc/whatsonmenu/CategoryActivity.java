package com.example.guneetpc.whatsonmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;
    CategoryAdapter categoryAdapter;
    ArrayList<CategoryModel> categoryModelArrayList;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        recyclerView=(RecyclerView)findViewById(R.id.category_rv);
        gridLayoutManager=new GridLayoutManager(this,2);
        categoryModelArrayList=new ArrayList<>();
        databaseHelper=new DatabaseHelper(getApplication());
        initializeArrayList();
        initializeDataBase();
        categoryAdapter=new CategoryAdapter(categoryModelArrayList,getApplicationContext(),this);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(categoryAdapter);
    }

    void initializeDataBase()
    {
        databaseHelper.addFoodItemToTable(new FoodItemModel("so1","Organic SouthWestern Corn Chowder","175","A delectable blend of roasted corn,red bell pepper,potatoes and peppers",R.drawable.soup,3,0),"soup");
        databaseHelper.addFoodItemToTable(new FoodItemModel("so2","Organic Smokey Split Pea","150","A hearty vegetarian pea soup with a hint of smoked chilly peppers",R.drawable.soup,4,0),"soup");
        databaseHelper.addFoodItemToTable(new FoodItemModel("so3","Tomato Bisque","175","A velvety smooth tomato and cream soup",R.drawable.soup,3,0),"soup");
        databaseHelper.addFoodItemToTable(new FoodItemModel("so4","Grandma Mary's Chicken Soup","180","A flavourful,soothing broth full of chicken ,carrots, noodles and dill",R.drawable.soup,3,0),"soup");
        databaseHelper.addFoodItemToTable(new FoodItemModel("so5","Mexican Chicken Tortilla Soup","160","A savoury blend of oven roasted tomatoes,grilled corn tortillas, garlic and herbs.",R.drawable.soup,4,0),"soup");
        databaseHelper.addFoodItemToTable(new FoodItemModel("so6","Turkey Chili","225","A thick,zesty chili made with grounded turkey,tomatoes,chili peppers and beans",R.drawable.soup,4,0),"soup");
        databaseHelper.addFoodItemToTable(new FoodItemModel("so7","New England Clam Chowder","220","A traditional recipe with clam,carrots and bacon",R.drawable.soup,5,0),"soup");

        databaseHelper.addFoodItemToTable(new FoodItemModel("bv1","Strawberry Fields","90","Strawberry,Banana and Apple Juice",R.drawable.beverage,5,0),"beverage");
        databaseHelper.addFoodItemToTable(new FoodItemModel("bv2","Peach -O- Rama ","100","Peach,Banana and Peach Juice",R.drawable.beverage,4,0),"beverage");
        databaseHelper.addFoodItemToTable(new FoodItemModel("bv3","Blu's Brother ","80","BlueBerry, Banana and Apple juice",R.drawable.beverage,5,0),"beverage");
        databaseHelper.addFoodItemToTable(new FoodItemModel("bv4","Very Very Berry","75","Strawberry, Blueberry and apple juice",R.drawable.beverage,3,0),"beverage");
        databaseHelper.addFoodItemToTable(new FoodItemModel("bv5","Dr. DayBreak","100","Peach,Banana and orange juice",R.drawable.beverage,1,0),"beverage");
        databaseHelper.addFoodItemToTable(new FoodItemModel("bv6","Tea","40","tea leafs, milk and sugar",R.drawable.beverage,2,0),"beverage");
        databaseHelper.addFoodItemToTable(new FoodItemModel("bv7","Coffee","40","Cocoa coffee beans, sugar and milk",R.drawable.beverage,5,0),"beverage");
        databaseHelper.addFoodItemToTable(new FoodItemModel("bv8","BlueBerry","80","BlueBerry,Vanilla ice cream and milk",R.drawable.beverage,4,0),"beverage");

        databaseHelper.addFoodItemToTable(new FoodItemModel("mo1","WaterMelon Colada","100","Strawberry,Banana and Apple Juice",R.drawable.mocktail,1,0),"mocktail");
        databaseHelper.addFoodItemToTable(new FoodItemModel("mo2","Deep Sea","110","Strawberry,Banana and Apple Juice",R.drawable.mocktail,4,0),"mocktail");
        databaseHelper.addFoodItemToTable(new FoodItemModel("mo3","Virgin Blue Lagoon","110","Strawberry,Banana and Apple Juice",R.drawable.mocktail,5,0),"mocktail");
        databaseHelper.addFoodItemToTable(new FoodItemModel("mo4","Lemon Iced Tea","140","Strawberry,Banana and Apple Juice",R.drawable.mocktail,3,0),"mocktail");
        databaseHelper.addFoodItemToTable(new FoodItemModel("mo5","Virgin Mojitos","120","Strawberry,Banana and Apple Juice",R.drawable.mocktail,4,0),"mocktail");
        databaseHelper.addFoodItemToTable(new FoodItemModel("mo6","Pink Panther","120","Strawberry,Banana and Apple Juice",R.drawable.mocktail,4,0),"mocktail");

        databaseHelper.addFoodItemToTable(new FoodItemModel("bu1","Southern Smokehouse Bacon Burger","325","With maple bacon, smoked cheddar, mayo, crispy onion strings and ancho-chile BBQ sauce",R.drawable.burger,4,0),"burger");
        databaseHelper.addFoodItemToTable(new FoodItemModel("bu2","Avocado Burger","330","With fresh avocado, red onion and swiss topped with avocado-ranch on a wheat bun",R.drawable.burger,5,0),"burger");
        databaseHelper.addFoodItemToTable(new FoodItemModel("bu3","Jalapeno Smokehouse Bacon Burger","275","With applewood smoked bacon, smoked cheddar, tortilla strips, red onion, mayo, jalapenos and jalapeno-ranch dressing",R.drawable.burger,3,0),"burger");
        databaseHelper.addFoodItemToTable(new FoodItemModel("bu4","Big Mouth Bites","300","Four mini burgers topped with applewood smoked bacon, american cheese, sauteed onions and ranch. Served with crispy onion strings and ranch dressing",R.drawable.burger,3,0),"burger");
        databaseHelper.addFoodItemToTable(new FoodItemModel("bu5","Shiner Bock BBQ Burger","275","A burger to crave, topped with sweet'n tangy Shiner Bock BBQ sauce, cheddar and crispy onion strings",R.drawable.burger,4,0),"burger");
        databaseHelper.addFoodItemToTable(new FoodItemModel("bu6","Oldtimer","275","Mouth-watering burger with mustard and red onion",R.drawable.burger,5,0),"burger");
        databaseHelper.addFoodItemToTable(new FoodItemModel("bu7","Classic Bacon Burger","275","A crowd-pleasing favorite topped with applewood smoked bacon, cheddar, red onion and mayo",R.drawable.burger,5,0),"burger");

        databaseHelper.addFoodItemToTable(new FoodItemModel("de1","Molten Chocolate Cake","250","Topped with vanilla ice cream under a hard chocolate shell",R.drawable.dessert,4,0),"dessert");
        databaseHelper.addFoodItemToTable(new FoodItemModel("de2","Frosty Chocolate Shake","220","Delicious thick & frosty chocolate shake made with real ice cream",R.drawable.dessert,5,0),"dessert");
        databaseHelper.addFoodItemToTable(new FoodItemModel("de3","Cheesecake","300","Decadant creamy New York style cheesecake with graham cracker crust. Served over fresh strawberry puree",R.drawable.dessert,3,0),"dessert");
        databaseHelper.addFoodItemToTable(new FoodItemModel("de4","Brownie Sundae","330","Warm, rich chocolate brownie topped with vanilla ice cream and hot fudge",R.drawable.dessert,3,0),"dessert");
        databaseHelper.addFoodItemToTable(new FoodItemModel("de5","Chocolate Chip Paradise Pie","299","Chewy bar of chocolate chips, walnuts and coconut. Topped with vanilla ice cream, hot fudge and caramel",R.drawable.dessert,5,0),"dessert");

        databaseHelper.addFoodItemToTable(new FoodItemModel("sv1","Hot Spinach & Artichoke Dip","220","Served with warm tostada chips",R.drawable.starter_veg,4,0),"starterVeg");
        databaseHelper.addFoodItemToTable(new FoodItemModel("sv2","Crispy Onion String & Jalapeno Stack","225","Served with ranch dressing",R.drawable.starter_veg,1,0),"starterVeg");
        databaseHelper.addFoodItemToTable(new FoodItemModel("sv3","Classic Nachos (Large)","199","With melted cheese, jalapenos, beans, queso and a hint of seasoned beef. Served with house-made pico de gallo and sour cream",R.drawable.starter_veg,5,0),"starterVeg");
        databaseHelper.addFoodItemToTable(new FoodItemModel("sv4","Fire-Grilled Corn Guacamole","145","With fresh avocados, cilantro, house-made pico de gallo, fire-grilled corn and jalapenos. Served with tostada chips and house-made salsa",R.drawable.starter_veg,5,0),"starterVeg");
        databaseHelper.addFoodItemToTable(new FoodItemModel("sv5","Fried Cheese","280","Served with marinara sauce",R.drawable.starter_veg,2,0),"starterVeg");
        databaseHelper.addFoodItemToTable(new FoodItemModel("sv6","Loaded Potato Skins","180","Topped with cheese, applewood smoked bacon, green onions and a side of sour cream",R.drawable.starter_veg,4,0),"starterVeg");
        databaseHelper.addFoodItemToTable(new FoodItemModel("sv7","Texas Cheese Fries with Chili","199","Topped with our famous chili, jalapenos, green onions and finished with applewood smoked bacon. Served with ranch dressing",R.drawable.starter_veg,3,0),"starterVeg");

        databaseHelper.addFoodItemToTable(new FoodItemModel("sn1","Skillet Queso","400","Cheese dip with seasoned beef. Served with warm tostada chips and our house-made salsa",R.drawable.starter_non_veg,4,0),"starterNonVeg");
        databaseHelper.addFoodItemToTable(new FoodItemModel("sn2","Triple Dipper","349","Pick your three favorites. Served with dipping sauces. Cheesesteak sliders, blackened chicken sliders, big mouth bites, boneless buffalo wings, southwestern eggrolls, loaded potato skins, chicken crispers, wings over buffalo, fried cheese, hot spinach & artichoke dip",R.drawable.starter_non_veg,4,0),"starterNonVeg");
        databaseHelper.addFoodItemToTable(new FoodItemModel("sn3","Classic Nachos (Regular) with Chicken or Fajita Beef","220","With melted cheese, jalapenos, beans, queso and a hint of seasoned beef. Served with house-made pico de gallo and sour cream",R.drawable.starter_non_veg,2,0),"starterNonVeg");
        databaseHelper.addFoodItemToTable(new FoodItemModel("sn4","Boneless Buffalo Wings","420","Breaded chicken breast tossed in spicy sauce. Served with cool bleu cheese and celery",R.drawable.starter_non_veg,5,0),"starterNonVeg");
        databaseHelper.addFoodItemToTable(new FoodItemModel("sn5","Wings Over Buffalo","380","Delicious chicken wings tossed in our spicy wing sauce. Served with cool bleu cheese dressing",R.drawable.starter_non_veg,1,0),"starterNonVeg");
        databaseHelper.addFoodItemToTable(new FoodItemModel("sn6","Classic Nachos (Large) with Chicken or Fajita Beef","190","With melted cheese, jalapenos, beans, queso and a hint of seasoned beef. Served with house-made pico de gallo and sour cream",R.drawable.starter_non_veg,2,0),"starterNonVeg");

        databaseHelper.addFoodItemToTable(new FoodItemModel("pi1","VEGGIE SUPREME","425","Mushroom, capsicum, onion, tomato, baby corn and olives.",R.drawable.pizza,4,0),"pizza");
        databaseHelper.addFoodItemToTable(new FoodItemModel("pi2","FIERY RIDE","450","Tomato, Onion, Capsicum, Sweet Corn , Olives , Jalapenos & Green Chillies",R.drawable.pizza,4,0),"pizza");
        databaseHelper.addFoodItemToTable(new FoodItemModel("pi3","EXOTICA","230","Red capsicum, baby corn, capsicum, olives and jalapenos.",R.drawable.pizza,5,0),"pizza");
        databaseHelper.addFoodItemToTable(new FoodItemModel("pi4","PANEER VEGORAMA","375","Paneer, Onion, Capsicum, Sweet Corn, Red Capsicum, Black Olives, Red Paprika & Green Chillies",R.drawable.pizza,3,0),"pizza");
        databaseHelper.addFoodItemToTable(new FoodItemModel("pi5","PANEER MAKHANI","375","Sweet corn, mushroom, tomato, onion and capsicum.",R.drawable.pizza,4,0),"pizza");
        databaseHelper.addFoodItemToTable(new FoodItemModel("pi6","COUNTRY FEAST","399","Mushroom, onion, tomato and capsicum",R.drawable.pizza,4,0),"pizza");
        databaseHelper.addFoodItemToTable(new FoodItemModel("pi7","VEGGIE LOVERS","425","",R.drawable.pizza,4,0),"pizza");


        databaseHelper.addFoodItemToTable(new FoodItemModel("pa1","TURBO PENNE ARRABBIATA","325","A fiery tomato sauce with garlic, basil, Scotch bonnet chillies, Bella Lodi & herby breadcrumbs",R.drawable.pasta,4,0),"pasta");
        databaseHelper.addFoodItemToTable(new FoodItemModel("pa2","PUMKIN RAVIOLI","330","Pasta filled with roasted squash, ricotta & English mustard in a pumpkin sauce with rosemary & crushed amaretti breadcrumbs",R.drawable.pasta,5,0),"pasta");
        databaseHelper.addFoodItemToTable(new FoodItemModel("pa3","FRESH CRAB SPAGHETTI","299","With garlic, capers, chilli, fennel, parsley, anchovies, lemon & olive oil",R.drawable.pasta,4,0),"pasta");
        databaseHelper.addFoodItemToTable(new FoodItemModel("pa4","WHITEE SAUCE PASTA WITH WHITE MUSHROOM","249","Creamy carnaroli rice with winter greens, roasted mushrooms, mozzarella & extra virgin olive oil",R.drawable.pasta,3,0),"pasta");
        databaseHelper.addFoodItemToTable(new FoodItemModel("pa5","PENNE CARBONARA","249","Crispy chunks of smoked pancetta, sweet buttery leeks, lemon & a traditional carbonara sauce",R.drawable.pasta,3,0),"pasta");
        databaseHelper.addFoodItemToTable(new FoodItemModel("pa6","BAKED CRESPELLE","300","Spinach & basil baked in gluten-free buckwheat pancakes with smoked mozzarella, sweet buttery leeks, Sicilian tomato sauce & Bella Lodi",R.drawable.pasta,3,0),"pasta");


        databaseHelper.addFoodItemToTable(new FoodItemModel("no1","Singapore Fried Noodles","180","Thin rice noodles with roast pork, shrimp, bean sprouts, onions, carrots and spring onions in a light curry sauce.",R.drawable.noodle,5,0),"noodle");
        databaseHelper.addFoodItemToTable(new FoodItemModel("no2","Black Bean Beef","165","Egg noodles with beef and fresh vegetables in a popular black bean sauce.",R.drawable.noodle,4,0),"noodle");
        databaseHelper.addFoodItemToTable(new FoodItemModel("no3","Combination Noodles","165","Egg noodles with prawn, beef, pork and chicken served with fresh and crispy vegetables in an oyster sauce.",R.drawable.noodle,4,0),"noodle");
        databaseHelper.addFoodItemToTable(new FoodItemModel("no4","Hot Box","190","Egg noodles with roast pork, chicken, beef and fresh vegetables in a Thai chili sauce.",R.drawable.noodle,4,0),"noodle");
        databaseHelper.addFoodItemToTable(new FoodItemModel("no5","Sweet Box","190","Egg noodles with roast pork, chicken, beef, pineapple, tomato and fresh vegetables in a special sweet sauce.",R.drawable.noodle,2,0),"noodle");
        databaseHelper.addFoodItemToTable(new FoodItemModel("no6","Hokkien Mee","175","vegetables in a satay sauce.",R.drawable.noodle,3,0),"noodle");
        databaseHelper.addFoodItemToTable(new FoodItemModel("no7","Satay Chicken","175","Egg noodles with chicken and fresh vegetables in a satay sauce.",R.drawable.noodle,1,0),"noodle");


        databaseHelper.addFoodItemToTable(new FoodItemModel("cg1","Spicy Vegetarian Thai Noodle Bowl","325","The Noodle Bowl is an easy one pot dish with a that is has a thai flavored light broth, packed with vegetables, noodles and sesame crusted tofu.",R.drawable.chinese_gravy,4,0),"chineseGravy");
        databaseHelper.addFoodItemToTable(new FoodItemModel("cg2","Spicy Schezwan Indo-Chinese Egg ","299","A spicy yet comforting rice dish, it is perfect dinner for monsoon nights or when you have guests over and want to serve them a Chinese meal",R.drawable.chinese_gravy,4,0),"chineseGravy");
        databaseHelper.addFoodItemToTable(new FoodItemModel("cg3","Indo-Chinese Paneer Manchurian ","299","Indo-Chinese Paneer Manchurian Recipe is a delicious and popular Indo-Chinese recipe, from the menus of many restaurants and street carts that dot India.",R.drawable.chinese_gravy,5,0),"chineseGravy");
        databaseHelper.addFoodItemToTable(new FoodItemModel("cg4","Mushroom Chilli","350","Mushroom Chilli Recipe is a delicious Chinese appetiser that is inspired by the Indian ingredients that make it a great combination of familiar Indian spices and Chinese flavours.",R.drawable.chinese_gravy,3,0),"chineseGravy");
        databaseHelper.addFoodItemToTable(new FoodItemModel("cg5","Tofu Stir Fry Curry","350"," The Saucy Tofu Stir Fry is makes a high protein healthy dinner along with a bowl of brown rice ",R.drawable.chinese_gravy,3,0),"chineseGravy");

        databaseHelper.addFoodItemToTable(new FoodItemModel("vg1","Spinach Kofta Curry","250","Spinach kofta curry is an exotic gravy-based dish. These spinach and potato koftas (also known as pakoras or dumplings) are simmered in rich creamy tomato gravy making this a very delicious dish.",R.drawable.indian_gravy_veg,4,0),"indianGravyVeg");
        databaseHelper.addFoodItemToTable(new FoodItemModel("vg2","Dahi Baingan sautéed Eggplant ","299","Dahi baingan (Sautéed Eggplant with Yogurt is a classic eggplant dish.",R.drawable.indian_gravy_veg,4,0),"indianGravyVeg");
        databaseHelper.addFoodItemToTable(new FoodItemModel("vg3","Paneer Makhani","349","Paneer Makhani is a popular Punjabi dish. Paneer (Indian cheese) simmered in rich creamy tomato gravy makes a very delicious dish.",R.drawable.indian_gravy_veg,4,0),"indianGravyVeg");
        databaseHelper.addFoodItemToTable(new FoodItemModel("vg4","Hyderabadi Mirchi Ka Salan","349","Mirch is pepper and Salan means curry. The chili pepper is cooked in a peanut and coconut spicy curry.",R.drawable.indian_gravy_veg,3,0),"indianGravyVeg");
        databaseHelper.addFoodItemToTable(new FoodItemModel("vg5","Cauliflower with Yogurt Gravy","299","Cauliflower in spiced yogurt gravy makes a very flavorful side dish. This dish is simply delicious and worth trying.",R.drawable.indian_gravy_veg,2,0),"indianGravyVeg");
        databaseHelper.addFoodItemToTable(new FoodItemModel("vg6","Mushroom Corn Cashew Curry","299","Corn and mushroom in tomato and spicy cashew gravy makes a delicious main dish.",R.drawable.indian_gravy_veg,3,0),"indianGravyVeg");
        databaseHelper.addFoodItemToTable(new FoodItemModel("vg7","Gobi (Cauliflower) Manchurian","299","Gobi manchurian satisfies your savory and spicy cravings! It consists of fried gobi simmered in a flavorful gravy made with soy sauce and red chili sauce.",R.drawable.indian_gravy_veg,5,0),"indianGravyVeg");

        databaseHelper.addFoodItemToTable(new FoodItemModel("ng1","mangalorean chicken curry","340","Kori Gassi or Mangalore chicken curry with coconut goes well pundi, rotti, neer dosa & rice.",R.drawable.indian_gravy_non_veg,4,0),"indianGravyNonVeg");
        databaseHelper.addFoodItemToTable(new FoodItemModel("ng2","Chicken Salna","349"," This easy & quick chicken curry of Tamil Nadu is tasty & is the best side with Parota.",R.drawable.indian_gravy_non_veg,4,0),"indianGravyNonVeg");
        databaseHelper.addFoodItemToTable(new FoodItemModel("ng3","Keema Matar","299"," Mincemeat green peas curry is a spiced North Indian style dish that goes well with pulao, rice or roti.",R.drawable.indian_gravy_non_veg,2,0),"indianGravyNonVeg");
        databaseHelper.addFoodItemToTable(new FoodItemModel("ng4","Chicken Ghee Roast","299","There are quite a few chicken dishes among Mangalore recipes. But a culinary gem among them all is the Chicken Ghee Roast. Goes well with ghee rice.",R.drawable.indian_gravy_non_veg,1,0),"indianGravyNonVeg");
        databaseHelper.addFoodItemToTable(new FoodItemModel("ng5","Anglo Indian Meatball Curry","299","Meatball curry, a mutton kheema recipe cooked in Indian spices, is classic Anglo Indian food served with coconut rice",R.drawable.indian_gravy_non_veg,5,0),"indianGravyNonVeg");
        databaseHelper.addFoodItemToTable(new FoodItemModel("ng6","Chicken 65","349","Chicken 65 recipe at last!",R.drawable.indian_gravy_non_veg,5,0),"indianGravyNonVeg");
        databaseHelper.addFoodItemToTable(new FoodItemModel("ng7","Prawn Fry","349","One of the classic Andhra recipes with shrimp, Royalla Vepudu aka Prawn Fry",R.drawable.indian_gravy_non_veg,3,0),"indianGravyNonVeg");

        databaseHelper.addFoodItemToTable(new FoodItemModel("br1","Garlic Naan","70","Delicious naan bread topped with chopped garlic, one of our most popular sides.",R.drawable.bread,4,0),"bread");
        databaseHelper.addFoodItemToTable(new FoodItemModel("br2","Keema Naan","80","A house speciality - naan bread stuffed with minced lamb, flavored with Indian spices.",R.drawable.bread,4,0),"bread");
        databaseHelper.addFoodItemToTable(new FoodItemModel("br3","Butter Naam","80","Naan bread rubbed with butter.",R.drawable.bread,4,0),"bread");
        databaseHelper.addFoodItemToTable(new FoodItemModel("br4","Tandoori Rooti","80","Whole wheat bread baked in our oven, an excellent accompaniment to any of our curries.",R.drawable.bread,5,0),"bread");
        databaseHelper.addFoodItemToTable(new FoodItemModel("br5","Laacha Parota","70","Indian bread made with whole-wheat flour and butter. The dough is rolled flat and folded to make layers before cooking, resulting in a soft flaky texture.",R.drawable.bread,5,0),"bread");
        databaseHelper.addFoodItemToTable(new FoodItemModel("br6","Butter Roti","70","Wheat Roti topped with butter",R.drawable.bread,2,0),"bread");

        databaseHelper.addFoodItemToTable(new FoodItemModel("be1","QUENCHING","390","Softly spicy and fruity German- and Belgian-style wheat beers",R.drawable.beer,4,0),"beer");
        databaseHelper.addFoodItemToTable(new FoodItemModel("be2","Blanche de Chambly (Québec; 5% alc.)","449","A light and refreshing Belgian-style wheat beer accented by the addition of coriander and orange peel.\n",R.drawable.beer,4,0),"beer");
        databaseHelper.addFoodItemToTable(new FoodItemModel("be3","Hopf Helle Weisse (Germany; 5.5% alc.)","449","This classic hefeweizen is light, creamy and refreshing, with mild flavours of vanilla and banana",R.drawable.beer,5,0),"beer");


        databaseHelper.addFoodItemToTable(new FoodItemModel("wh1","Auchentoshan Classic","499","Honey with light citrus fruit",R.drawable.whisky,4,0),"whisky");
        databaseHelper.addFoodItemToTable(new FoodItemModel("wh2","Auchentoshan Three Wood","499","Subtle fruit, chocolate and raisins with hints of spice",R.drawable.whisky,2,0),"whisky");
        databaseHelper.addFoodItemToTable(new FoodItemModel("wh3","Auchentoshan 18","549","Almonds and citrus peels, nutty with pleasing spice",R.drawable.whisky,2,0),"whisky");
        databaseHelper.addFoodItemToTable(new FoodItemModel("wh4","Arran 10","549","Zesty lemon nose, malty with fudge tones and spicy finish",R.drawable.whisky,3,0),"whisky");
        databaseHelper.addFoodItemToTable(new FoodItemModel("wh5","Balblair 03","549","Floral with zesty notes yet elegantly sweet and spicy",R.drawable.whisky,4,0),"whisky");
        databaseHelper.addFoodItemToTable(new FoodItemModel("wh6","Glenkichie 12","499","Earthy with dried fruit and elegant spice",R.drawable.whisky,4,0),"whisky");
        databaseHelper.addFoodItemToTable(new FoodItemModel("wh7","Blair Athol 12","499","Light and dry with delicate smoke and citrus",R.drawable.whisky,4,0),"whisky");

        databaseHelper.addCommentToTable(new Comment("co1", "so1", "Excellent"));
        databaseHelper.addCommentToTable(new Comment("co2","so1","Delicious"));
        databaseHelper.addCommentToTable(new Comment("co3","so1","Really Tempting"));
        databaseHelper.addCommentToTable(new Comment("co4","so1","Served Cold"));

    }

    void initializeArrayList()
    {
        categoryModelArrayList.add(new CategoryModel(R.drawable.soup,"SOUPS","soup"));
        categoryModelArrayList.add(new CategoryModel(R.drawable.beverage,"BEVERAGES","beverage"));
        categoryModelArrayList.add(new CategoryModel(R.drawable.mocktail,"MOCKTAILS","mocktail"));
        categoryModelArrayList.add(new CategoryModel(R.drawable.beer,"BEER","beer"));
        categoryModelArrayList.add(new CategoryModel(R.drawable.whisky,"WHISKY","whisky"));
        categoryModelArrayList.add(new CategoryModel(R.drawable.starter_veg,"VEG STARTERS","starterVeg"));
        categoryModelArrayList.add(new CategoryModel(R.drawable.starter_non_veg,"NON VEG STARTERS","starterNonVeg"));
        categoryModelArrayList.add(new CategoryModel(R.drawable.pizza,"PIZZAS","pizza"));
        categoryModelArrayList.add(new CategoryModel(R.drawable.burger,"BURGERS","burger"));
        categoryModelArrayList.add(new CategoryModel(R.drawable.pasta,"PASTAS","pasta"));
        categoryModelArrayList.add(new CategoryModel(R.drawable.noodle,"NOODLES","noodle"));
        categoryModelArrayList.add(new CategoryModel(R.drawable.chinese_gravy,"CHINESE GRAVIES","chineseGravy"));
        categoryModelArrayList.add(new CategoryModel(R.drawable.indian_gravy_veg,"VEG INDIAN GRAVIES","indianGravyVeg"));
        categoryModelArrayList.add(new CategoryModel(R.drawable.indian_gravy_non_veg,"NON VEG INDIAN GRAVIES","indianGravyNonVeg"));
        categoryModelArrayList.add(new CategoryModel(R.drawable.bread,"BREADS","bread"));
        categoryModelArrayList.add(new CategoryModel(R.drawable.dessert,"DESSERTS","dessert"));
    }
}
