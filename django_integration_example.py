"""
Complete Django integration example for the users list view.

This file shows how to integrate the users list view into your Django project.
"""

# ===== views.py =====
"""
Add this to your Django app's views.py file:
"""

from django.http import JsonResponse
from django.views import View
from django.contrib.auth.models import User
from django.core.serializers.json import DjangoJSONEncoder


def get_all_users_json(request):
    """
    Simple view to return all users as JSON.
    
    Returns:
    - GET: JSON response with all users
    - Other methods: 405 Method Not Allowed
    """
    if request.method == 'GET':
        # Get all users with specific fields
        users = User.objects.all().values(
            'id', 
            'username', 
            'email', 
            'first_name', 
            'last_name', 
            'date_joined', 
            'is_active'
        )
        
        # Convert QuerySet to list
        users_list = list(users)
        
        # Return JSON response
        return JsonResponse({
            'status': 'success',
            'message': 'Users retrieved successfully',
            'count': len(users_list),
            'users': users_list
        }, encoder=DjangoJSONEncoder, safe=False)
    
    else:
        return JsonResponse({
            'status': 'error',
            'message': 'Method not allowed'
        }, status=405)


# ===== urls.py =====
"""
Add this to your Django app's urls.py file:
"""

from django.urls import path
from . import views

urlpatterns = [
    path('api/users/', views.get_all_users_json, name='get_all_users'),
    # Add other URL patterns here...
]

# ===== Main project urls.py =====
"""
In your main project's urls.py file, include the app URLs:
"""

from django.contrib import admin
from django.urls import path, include

urlpatterns = [
    path('admin/', admin.site.urls),
    path('', include('your_app_name.urls')),  # Replace 'your_app_name' with your actual app name
]


# ===== Example API Response =====
"""
When you make a GET request to /api/users/, you'll get a response like this:

{
    "status": "success",
    "message": "Users retrieved successfully",
    "count": 2,
    "users": [
        {
            "id": 1,
            "username": "admin",
            "email": "admin@example.com",
            "first_name": "John",
            "last_name": "Doe",
            "date_joined": "2024-01-15T10:30:00.000Z",
            "is_active": true
        },
        {
            "id": 2,
            "username": "testuser",
            "email": "test@example.com",
            "first_name": "Jane",
            "last_name": "Smith",
            "date_joined": "2024-02-01T14:20:00.000Z",
            "is_active": true
        }
    ]
}
"""

# ===== Testing the View =====
"""
You can test this view in several ways:

1. Using Django's test client:
"""

from django.test import TestCase, Client
from django.contrib.auth.models import User
from django.urls import reverse
import json

class UsersViewTest(TestCase):
    def setUp(self):
        self.client = Client()
        # Create test users
        User.objects.create_user(username='testuser1', email='test1@example.com')
        User.objects.create_user(username='testuser2', email='test2@example.com')
    
    def test_get_users_json(self):
        response = self.client.get('/api/users/')
        self.assertEqual(response.status_code, 200)
        
        data = json.loads(response.content)
        self.assertEqual(data['status'], 'success')
        self.assertEqual(data['count'], 2)
        self.assertIn('users', data)

"""
2. Using curl from command line:
curl -X GET http://localhost:8000/api/users/

3. Using Python requests:
import requests
response = requests.get('http://localhost:8000/api/users/')
print(response.json())
"""

# ===== Security Considerations =====
"""
Important security notes:

1. Consider adding authentication:
   - Use @login_required decorator for function-based views
   - Use permission_classes for DRF views

2. Limit exposed user data:
   - Don't expose sensitive fields like passwords
   - Consider what user information should be public

3. Add rate limiting:
   - Use django-ratelimit or similar packages
   - Prevent abuse of the API endpoint

4. Add CORS headers if needed:
   - Use django-cors-headers for cross-origin requests

Example with authentication:
"""

from django.contrib.auth.decorators import login_required

@login_required
def get_all_users_json_protected(request):
    # Same implementation as above
    # But now requires user to be logged in
    pass

# ===== Installation Requirements =====
"""
Make sure you have Django installed:

pip install Django

If you want to use Django REST Framework (recommended for APIs):

pip install djangorestframework

Then add 'rest_framework' to your INSTALLED_APPS in settings.py
"""

