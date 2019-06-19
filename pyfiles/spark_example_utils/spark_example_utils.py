import random


def sample(p):
    x, y = random.random(), random.random()
    return 1 if x*x + y*y < 1 else 0

