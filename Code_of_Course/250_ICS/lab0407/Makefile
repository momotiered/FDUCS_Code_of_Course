CC = gcc
CFLAGS = -Wall -g

all: array_test struct_test function_pointer_test

array_test: array_test.c
	$(CC) $(CFLAGS) -o $@ $<

struct_test: struct_test.c
	$(CC) $(CFLAGS) -o $@ $<

function_pointer_test: function_pointer_test.c
	$(CC) $(CFLAGS) -o $@ $<

clean:
	rm -f array_test struct_test function_pointer_test

.PHONY: all clean 