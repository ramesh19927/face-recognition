package org.opencv.javacv.facerecognition;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.app.Activity;
import android.os.Environment;
import android.service.wallpaper.WallpaperService;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;

import java.io.File;
import java.util.ArrayList;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;

import org.opencv.imgproc.Imgproc;
import org.opencv.javacv.facerecognition.GalleryImageAdapter;


public class Imagearray extends Activity {

    private Integer images[] = {R.drawable.icon, R.drawable.ic_red, R.drawable.ic_stat_camera};
    private int currImage = 0;
     public static Bitmap bit;
   public static ArrayList<Mat> matsarr=new ArrayList<Mat>();
    public static ArrayList<Bitmap> bitmaps=new ArrayList<Bitmap>();
    ImageView selectedImage;
   public Bitmap bitmap;
    public File imgFile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagearray);
               selectedImage=(ImageView)findViewById(R.id.imageView);
        Gallery gallery = (Gallery) findViewById(R.id.gallery);
        selectedImage=(ImageView)findViewById(R.id.imageView);
        gallery.setSpacing(1);
        final GalleryImageAdapter galleryImageAdapter= new GalleryImageAdapter(this);
        gallery.setAdapter(galleryImageAdapter);


        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                // show the selected Image
                selectedImage.setImageBitmap(galleryImageAdapter.bitmaps.get(position));
            }
        });


    }

    public void deleteRecursive(File fileOrDirectory) {
        if (fileOrDirectory.isDirectory())
            for (File child : fileOrDirectory.listFiles())
                deleteRecursive(child);

        fileOrDirectory.delete();
    }

public void onDestroy() {
        super.onDestroy();
    File file=new File(Environment.getExternalStorageDirectory()+File.separator);

    deleteRecursive(file);

}
    public void onStop() {
        super.onStop();
        File file=new File(Environment.getExternalStorageDirectory()+File.separator);

        deleteRecursive(file);




    }



}