CONVERTER=inkscape

SRCS=$(shell echo *.svg)
OBJS=${SRCS:.svg=.pdf}

.PHONY: all clean

all: $(OBJS)

clean:
	rm $(OBJS)

%.pdf : %.svg
	$(CONVERTER) -A $@ $<
