package mic.maev.viewmodelpractic;

import android.os.CountDownTimer;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    public MutableLiveData<String> timer = new MutableLiveData<>();
    public MutableLiveData<String> link = new MutableLiveData<>();

    public LiveData<String> startTimer(){
        new CountDownTimer(10000, 1000){

            @Override
            public void onTick(long millisUntilFinished) {
                timer.setValue(Long.toString(millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                timer.setValue("Finished!");
                link.setValue("https://icons-for-free.com/iconfiles/png/512/Android-1320568265274623818.png");
            }
        }.start();
        return timer;
    }
}
