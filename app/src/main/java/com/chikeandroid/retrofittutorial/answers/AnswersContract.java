package com.chikeandroid.retrofittutorial.answers;

import com.chikeandroid.retrofittutorial.BasePresenter;
import com.chikeandroid.retrofittutorial.BaseView;
import com.chikeandroid.retrofittutorial.data.model.Item;

import java.util.List;

/**
 * Created by Chike on 12/4/2016.
 */

public interface AnswersContract {

    interface View extends BaseView<Presenter> {
        void showAnswers(List<Item> answers);

        void showErrorMessage();
    }

    interface Presenter extends BasePresenter {

        void loadAnswers();
    }
}
