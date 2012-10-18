<h1>School</h1>


Initial set-up

<pre>
<code>git clone https://github.com/thomasstr/School.git
cd School</code>
</pre>

You´ll want to add a remote called upstream pointing to the canonical repository. This will allow you to easily keep your local master up-to-date.
<pre>
<code>git remote add upstream 
git://github.com/thomasstr/School.git</code>
</pre>

<h3>Keeping everything up-to-date</h3>

Assuming you already have master checked out, run:
<pre>
<code>git fetch upstream
git merge --ff-only upstream/master</code>
</pre>

<h3>Compiling pg3400-12 files from source</h3>

<h4>Example:</h4>
<code>
gcc -Wall -Werror -std=c99 -o varargs_ex_2 varargs_ex_2.c
</code>