package com.example.gravity.devxplore.view.ui.details.following;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.support.annotation.NonNull;

import com.example.gravity.devxplore.application.AppExecutors;
import com.example.gravity.devxplore.data.DataInterface;
import com.example.gravity.devxplore.data.DataRepository;
import com.example.gravity.devxplore.data.db.AppDatabase;
import com.example.gravity.devxplore.data.db.dao.UserDao;
import com.example.gravity.devxplore.data.model.User;

import java.util.List;

/**
 * Created by gravity on 8/29/17.
 */

public class FollowingViewModel extends AndroidViewModel {
    private static final String TAG = "FollowingViewModel";

    private MutableLiveData<String> mCurrentUser = new MutableLiveData<>();

    private LiveData<List<User>> userFollowing = new MediatorLiveData<>();

    private DataInterface mDataRepository;

    public FollowingViewModel(Application application) {
        super(application);
        AppExecutors appExecutors = AppExecutors.getInstance();
        AppDatabase mDb = AppDatabase.getDatabaseInstance(this.getApplication());
        UserDao mUserDao = mDb.userDao();
        mDataRepository = DataRepository.getInstance(mDb, mUserDao, appExecutors);
        userFollowing = Transformations.switchMap(mCurrentUser, current -> mDataRepository.getUserFollowing(current));
    }

    public void setCurrentUser(@NonNull String username) {
        mCurrentUser.setValue(username);
    }

    public LiveData<List<User>> getUserFollowing() {
        return userFollowing;
    }

    public void setFavourite(String username, boolean isFavourite) {
        mDataRepository.setFavourite(username, isFavourite);
    }
}
