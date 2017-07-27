package com.example.junghwanpark.newsappmodify;

import android.os.AsyncTask;
import android.widget.Toast;

import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;

/**
 * Created by JungHwanPark on 7/26/2017.
 */

public class NewsJob extends JobService {
    AsyncTask mBackgroundTask;

    //This class that extends to jobservice will handle multiple requests from the previous schedule.

    @Override
    public boolean onStartJob(final JobParameters job) {
        mBackgroundTask = new AsyncTask() {
            @Override
            protected void onPreExecute() {
                Toast.makeText(NewsJob.this, "News refreshed", Toast.LENGTH_SHORT).show();
                super.onPreExecute();
            }

            @Override
            protected Object doInBackground(Object[] params) {
                RefreshTasks.refreshArticles(NewsJob.this);
                return null;
            }

            @Override
            protected void onPostExecute(Object o) {
                jobFinished(job, false);
                super.onPostExecute(o);

            }
        };


        mBackgroundTask.execute();

        return true;
    }

    //This methods will stop the execution of the job
    @Override
    public boolean onStopJob(JobParameters job) {

        if (mBackgroundTask != null) mBackgroundTask.cancel(false);

        return true;
    }
}

