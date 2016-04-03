app.factory('NoteService', ['$http', '$q', function($http, $q){

    return {

        getAllUserNotes: function(userId) {
            return $http.get(serverPath + '/users/' + userId + '/notes/')
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        console.error('Error while fetching notes');
                        return $q.reject(errResponse);
                    }
                );
        },

        createNote: function(userId, note){
            return $http.post(serverPath + '/users/' + userId + '/notes/', note)
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        console.error('Error while creating note');
                        return $q.reject(errResponse);
                    }
                );
        },

        updateNote: function(userId, note, id){
            return $http.put(serverPath + '/users/' + userId + '/notes/' + id, note)
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        console.error('Error while updating note');
                        return $q.reject(errResponse);
                    }
                );
        },

        deleteNote: function(userId, id){
            return $http.delete(serverPath + '/users/' + userId + '/notes/' + id)
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        console.error('Error while deleting note');
                        return $q.reject(errResponse);
                    }
                );
        }

    };

}]);