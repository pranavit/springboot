app.factory("myfactory",function($http){
	return  {
		getAllUsers : function(){
			return $http.get("/users/");
		},
		getUser : function(id){
			return $http.get("/users/"+id);
		},
		deleteUser : function(id){
			return $http.delete("users/delete/"+id);
		},
		saveUser : function(data){
			return $http.post("users/save/",data);	
		}
	}
});