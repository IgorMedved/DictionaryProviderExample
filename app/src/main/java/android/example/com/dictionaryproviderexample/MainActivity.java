/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package android.example.com.dictionaryproviderexample;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.UserDictionary;
import android.provider.UserDictionary.Words;
import android.support.v7.app.AppCompatActivity;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;



/**
 * This is the central activity for the Provider Dictionary Example App. The purpose of this app is
 * to show an example of accessing the {@link Words} list via its' Content Provider.
 */
public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the TextView which will be populated with the Dictionary ContentProvider data.
        //TextView dictTextView = (TextView) findViewById(R.id.dictionary_text_view);

        // Get the ContentResolver which will send a message to the ContentProvider
        ContentResolver resolver = getContentResolver();

        // Get a Cursor containing all of the rows in the Words table
        Cursor cursor = resolver.query(UserDictionary.Words.CONTENT_URI, null, null, null, null);
        //int counter = 0;
//        //ArrayList<String> wordEntries = new ArrayList<>();
//
//        RecyclerView recycler = (RecyclerView)findViewById(R.id.dictionary_recycler);
//
//        RecyclerView.Adapter<ViewHolder> adapter = new RecyclerView.Adapter<>(this, R.layout.activity_main, wordEntries);
//        GridLayoutManager manager = new GridLayoutManager(this,cursor.getColumnCount());
//        recycler.setAdapter(adapter);
        CursorAdapter adapter = new SimpleCursorAdapter (this,
                R.layout.textcell,
                cursor,
                new String[]{Words.WORD, Words.FREQUENCY},
                new int[]{R.id.text1, R.id.text2},
                0);
        ListView dictListView = (ListView) findViewById(R.id.dictionary_list_view);
        dictListView.setAdapter(adapter);
        //TextView myText= (TextView)findViewById(R.id.dictionary_text_view);
        /*StringBuilder textBuilder =new StringBuilder();


        textBuilder.append("The UserDictionary contains ").append(cursor.getCount()).append(" word");
        if (cursor.getCount() !=1)
            textBuilder.append("s");

        textBuilder.append(".\n");
        textBuilder.append("COLUMNS\t");


        textBuilder.append(cursor.getColumnName(3)).append("\t");
        textBuilder.append(cursor.getColumnName(4)).append( "\t");
        textBuilder.append(cursor.getColumnName(2)).append( "\t");
        textBuilder.append("\n");
        while (cursor.moveToNext())
        {
            textBuilder.append(cursor.getPosition()+1).append("\t");
            textBuilder.append(cursor.getString(4)).append("\t");
            textBuilder.append(cursor.getString(2)).append("\t");

            textBuilder.append("\n");
        }

       // myText.setText(textBuilder.toString());

        cursor.close();


       /* while (cursor.moveToNext())
        {
            counter++;
        }

        String content = "The " +cursor.getCount();*/
    }
}
