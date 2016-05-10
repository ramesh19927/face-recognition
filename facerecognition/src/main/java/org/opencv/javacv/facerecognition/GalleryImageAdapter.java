package org.opencv.javacv.facerecognition;

/**
 * Created by Ramesh-PC on 4/24/2016.
 */
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

import java.io.File;
import java.util.ArrayList;


public class GalleryImageAdapter extends BaseAdapter{
    private Context mContext;
public static File imgFile;
    public static File file;
    public static Bitmap bitmap;
    public static ArrayList<Bitmap> bitmaps=new ArrayList<Bitmap>();



    public GalleryImageAdapter(Context context)
    {
        mContext = context;
    }

    public int getCount() {
        return mImageIds.length;
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }


    // Override this method according to your need
    public View getView(int index, View view, ViewGroup viewGroup)
    {
        file=new File(Environment.getExternalStorageDirectory()+File.separator);
        if(file.listFiles().length!=0){
        for(int k=0;k<file.listFiles().length;k++) {
            imgFile = new File(Environment.getExternalStorageDirectory() + File.separator + k + ".jpg");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            bitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath(), options);
            bitmaps.add(bitmap);

            Log.i("aakasham", bitmaps.size() + " is the number you idiot!!!!! ");
        }

        }else {

        }

        // TODO Auto-generated method stub
        ImageView i = new ImageView(mContext);


         i.setImageBitmap(bitmaps.get(index));
        i.setLayoutParams(new Gallery.LayoutParams(200, 200));

        i.setScaleType(ImageView.ScaleType.FIT_XY);




        return i;



    }



    public Integer[] mImageIds = {
            R.drawable.ic_red,
            R.drawable.ic_stat_camera,
            R.drawable.ic_green,
            R.drawable.common_full_open_on_phone,
            R.drawable.ic_yellow,
            R.drawable.icon,
            R.drawable.lightbulb,
            R.drawable.lightbulb
    };



}