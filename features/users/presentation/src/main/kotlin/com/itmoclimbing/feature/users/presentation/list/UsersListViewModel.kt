package com.itmoclimbing.feature.users.presentation.list

import androidx.lifecycle.MutableLiveData
import com.itmoclimbing.domainCommon.model.User
import com.itmoclimbing.domainCommon.repository.UsersRepository
import com.itmoclimbing.feature.users.navigation.UsersScreenNavigation
import com.itmoclimbing.feature.users.presentation.UserCreatedCallback
import com.kommander.components.android.viewmodel.BaseViewModel
import com.kommander.components.android.viewmodel.livedata.ContentEvent
import com.kommander.components.android.viewmodel.livedata.dispatchTo
import io.reactivex.disposables.Disposable
import toothpick.InjectConstructor

@InjectConstructor
class UsersListViewModel(
        private val usersRepository: UsersRepository,
        private val userCreatedCallback: UserCreatedCallback,
        private val usersScreenNavigation: UsersScreenNavigation
) : BaseViewModel() {

    val usersListLiveData: MutableLiveData<ContentEvent<List<User>>> by lazy { MutableLiveData<ContentEvent<List<User>>>() }

    private var loadingDisposable: Disposable? = null
    private var userCreationDisposable: Disposable? = null

    private var routeId: Int? = null

    fun init(routeId: Int?) {
        this.routeId = routeId
        loadUsers()
    }

    fun onFabClick() {
        userCreationDisposable?.dispose()
        userCreationDisposable = userCreatedCallback
                .result
                .subscribe {
                    loadUsers()
                    userCreationDisposable?.dispose()
                }
        usersScreenNavigation.openCreateUser()
    }

    fun loadUsers() {
        loadingDisposable?.dispose()
        loadingDisposable = (routeId?.let(usersRepository::getUsersByRouteId) ?: usersRepository.getAllUsers()).dispatchTo(usersListLiveData)
    }

}