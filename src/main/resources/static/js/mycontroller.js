app.controller("mycontroller",function($scope,myfactory){
	
	var self = this;
	
	self.getUsers = function(){
		myfactory.getAllUsers().then(function(response){
			self.users = angular.copy(response.data.data);
		},function(err){
			
		});
	}
	
	self.deleteById = function(id){
		myfactory.deleteUser(id).then(function(response){
			self.getUsers();
		},function(err){
			
		});
	}
	
	self.saveUser = function(){
		myfactory.saveUser(self.newUser).then(function(response){
			self.getUsers();
			$("#myModal").modal("hide");
		},function(err){
			
		});
	}
	
	self.edit = function(data){
		self.newUser = angular.copy(data);
		$("#myModal").modal("show");
	}
	
	self.getUsers();
});