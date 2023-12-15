# test_fixtures_2.py
import pytest

# Data fixtures using decorators
@pytest.fixture
def data_fixture_1():
    return {'name': 'John', 'age': 25, 'city': 'New York'}

@pytest.fixture
def data_fixture_2():
    return {'name': 'Alice', 'age': 30, 'city': 'San Francisco'}

@pytest.fixture
def data_fixture_3():
    return {'name': 'Bob', 'age': 22, 'city': 'Seattle'}

# Test functions using fixtures
def test_user_name(data_fixture_1):
    assert data_fixture_1['name'] == 'John'

def test_user_age(data_fixture_2):
    assert data_fixture_2['age'] == 30

def test_user_city(data_fixture_3):
    assert data_fixture_3['city'] == 'Seattle'