package com.itmoclimbing.feature.users.presentation.creation

import androidx.lifecycle.MutableLiveData
import com.itmoclimbing.domainCommon.repository.UsersRepository
import com.itmoclimbing.feature.users.navigation.UsersScreenNavigation
import com.itmoclimbing.feature.users.presentation.UserCreatedCallback
import com.kommander.components.android.viewmodel.BaseViewModel
import com.kommander.components.android.viewmodel.livedata.Event
import com.kommander.components.android.viewmodel.livedata.dispatchTo
import timber.log.Timber
import toothpick.InjectConstructor

@InjectConstructor
class CreateUserViewModel(
        private val usersRepository: UsersRepository,
        private val usersScreenNavigation: UsersScreenNavigation,
        private val userCreatedCallback: UserCreatedCallback
) : BaseViewModel() {

    val loadingStatusLiveData: MutableLiveData<Event> = MutableLiveData()

    fun addUser(
            firstName: String,
            lastName: String
    ) {
        usersRepository
                .addUser(firstName, lastName)
                .doOnComplete {
                    userCreatedCallback.result.onNext(true)
                    usersScreenNavigation.back()
                }
                .doOnError {
                    Timber.e(it)
                }
                .dispatchTo(loadingStatusLiveData)
                .untilCleared()
    }

}