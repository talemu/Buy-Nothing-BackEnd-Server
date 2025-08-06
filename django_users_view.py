"""
Django view to return a list of all users in JSON format.

This file contains different approaches to create a Django view that returns
all users as JSON. Choose the approach that best fits your needs.
"""

from django.http import JsonResponse
from django.views import View
from django.views.generic import ListView
from django.contrib.auth.models import User
from django.core import serializers
from django.core.serializers.json import DjangoJSONEncoder
from django.utils.decorators import method_decorator
from django.views.decorators.csrf import csrf_exempt
from django.contrib.auth.decorators import login_required
import json


# Approach 1: Function-based view (Simple)
def users_list_json(request):
    """
    Simple function-based view that returns all users as JSON.
    
    Usage in urls.py:
    path('api/users/', views.users_list_json, name='users_list_json'),
    """
    if request.method == 'GET':
        users = User.objects.all().values('id', 'username', 'email', 'first_name', 'last_name', 'date_joined', 'is_active')
        users_list = list(users)
        return JsonResponse({
            'status': 'success',
            'count': len(users_list),
            'users': users_list
        }, encoder=DjangoJSONEncoder)
    else:
        return JsonResponse({'error': 'Method not allowed'}, status=405)


# Approach 2: Class-based view
class UsersListView(View):
    """
    Class-based view that returns all users as JSON.
    
    Usage in urls.py:
    path('api/users/', views.UsersListView.as_view(), name='users_list'),
    """
    
    def get(self, request):
        users = User.objects.all().values(
            'id', 'username', 'email', 'first_name', 'last_name', 
            'date_joined', 'is_active', 'is_staff', 'last_login'
        )
        users_list = list(users)
        
        return JsonResponse({
            'status': 'success',
            'count': len(users_list),
            'users': users_list
        }, encoder=DjangoJSONEncoder)


# Approach 3: More detailed view with error handling and pagination
class DetailedUsersListView(View):
    """
    More comprehensive view with error handling, optional pagination, and filtering.
    
    Usage in urls.py:
    path('api/users/', views.DetailedUsersListView.as_view(), name='detailed_users_list'),
    
    Query parameters:
    - page: Page number for pagination (optional)
    - limit: Number of users per page (optional, default: 20)
    - active_only: Return only active users (optional, default: false)
    """
    
    def get(self, request):
        try:
            # Get query parameters
            page = int(request.GET.get('page', 1))
            limit = int(request.GET.get('limit', 20))
            active_only = request.GET.get('active_only', 'false').lower() == 'true'
            
            # Build queryset
            queryset = User.objects.all()
            
            if active_only:
                queryset = queryset.filter(is_active=True)
            
            # Calculate pagination
            total_users = queryset.count()
            start = (page - 1) * limit
            end = start + limit
            
            # Get users with selected fields
            users = queryset[start:end].values(
                'id', 'username', 'email', 'first_name', 'last_name',
                'date_joined', 'last_login', 'is_active', 'is_staff', 'is_superuser'
            )
            
            users_list = list(users)
            
            # Calculate pagination info
            total_pages = (total_users + limit - 1) // limit
            has_next = page < total_pages
            has_previous = page > 1
            
            return JsonResponse({
                'status': 'success',
                'pagination': {
                    'current_page': page,
                    'total_pages': total_pages,
                    'total_users': total_users,
                    'users_per_page': limit,
                    'has_next': has_next,
                    'has_previous': has_previous
                },
                'users': users_list
            }, encoder=DjangoJSONEncoder)
            
        except ValueError as e:
            return JsonResponse({
                'status': 'error',
                'message': 'Invalid pagination parameters'
            }, status=400)
        except Exception as e:
            return JsonResponse({
                'status': 'error',
                'message': 'An error occurred while fetching users'
            }, status=500)


# Approach 4: Protected view (requires authentication)
@method_decorator(login_required, name='dispatch')
class ProtectedUsersListView(View):
    """
    Protected view that requires user authentication.
    Only authenticated users can access the users list.
    
    Usage in urls.py:
    path('api/users/protected/', views.ProtectedUsersListView.as_view(), name='protected_users_list'),
    """
    
    def get(self, request):
        # Check if user has permission to view users
        if not request.user.is_staff:
            return JsonResponse({
                'status': 'error',
                'message': 'Permission denied. Staff access required.'
            }, status=403)
        
        users = User.objects.all().values(
            'id', 'username', 'email', 'first_name', 'last_name',
            'date_joined', 'last_login', 'is_active', 'is_staff'
        )
        
        return JsonResponse({
            'status': 'success',
            'count': users.count(),
            'users': list(users),
            'requested_by': request.user.username
        }, encoder=DjangoJSONEncoder)


# Approach 5: Using Django REST Framework (if available)
"""
If you're using Django REST Framework, here's a more advanced approach:

from rest_framework.views import APIView
from rest_framework.response import Response
from rest_framework import status
from rest_framework.permissions import IsAuthenticated
from django.contrib.auth.models import User
from rest_framework import serializers

class UserSerializer(serializers.ModelSerializer):
    class Meta:
        model = User
        fields = ['id', 'username', 'email', 'first_name', 'last_name', 
                 'date_joined', 'last_login', 'is_active']

class UsersAPIView(APIView):
    permission_classes = [IsAuthenticated]
    
    def get(self, request):
        users = User.objects.all()
        serializer = UserSerializer(users, many=True)
        return Response({
            'status': 'success',
            'count': len(serializer.data),
            'users': serializer.data
        }, status=status.HTTP_200_OK)

# Usage in urls.py:
# path('api/users/', views.UsersAPIView.as_view(), name='users_api'),
"""


# Example URLs configuration (urls.py)
"""
from django.urls import path
from . import views

urlpatterns = [
    # Simple function-based view
    path('api/users/', views.users_list_json, name='users_list_json'),
    
    # Class-based view
    path('api/users/class/', views.UsersListView.as_view(), name='users_list_class'),
    
    # Detailed view with pagination
    path('api/users/detailed/', views.DetailedUsersListView.as_view(), name='users_list_detailed'),
    
    # Protected view
    path('api/users/protected/', views.ProtectedUsersListView.as_view(), name='users_list_protected'),
]
"""

# Example usage in your Django app:
"""
1. Add the view to your views.py file
2. Configure the URL in your urls.py file
3. Make sure you have the User model imported from django.contrib.auth.models
4. Test the endpoint: GET /api/users/

Example response:
{
    "status": "success",
    "count": 3,
    "users": [
        {
            "id": 1,
            "username": "admin",
            "email": "admin@example.com",
            "first_name": "Admin",
            "last_name": "User",
            "date_joined": "2024-01-01T00:00:00Z",
            "is_active": true
        },
        ...
    ]
}
"""

